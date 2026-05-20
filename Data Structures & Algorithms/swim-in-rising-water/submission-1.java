class Solution {
    public int swimInWater(int[][] grid) {
        /*
        djikstra's with a twist

        find the path with the lowest max
        probably use min heap somehow
        - go through paths to the end, add the highest value to a heap
        - pick the one with the lowest max

        heap stores: [max value seen so far, row, col]
        dist[i][j] = minimum possible "max value" to reach cell (i,j)

        1. Start at [grid[0][0], 0, 0]
        2. Poll the cell with lowest max value
        3. For each neighbor, new_cost = max(current_max, grid[neighbor])
        4. If new_cost < dist[neighbor], update and add to heap
        5. When you pop (n-1, n-1), return its cost
        */
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparing(a -> a[0])
        );
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxCost = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int curCost = curr[0];
            int row = curr[1];
            int col = curr[2];
            if (visited[row][col]) continue;
            if (row == grid.length-1 && col == grid[0].length-1) return curCost;
            visited[row][col] = true;
            maxCost = curCost;

            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !visited[r][c])
                {
                    minHeap.offer(new int[] {Math.max(grid[r][c], maxCost), r, c});
                }
            }

        }
        return maxCost;
        
    }
}
