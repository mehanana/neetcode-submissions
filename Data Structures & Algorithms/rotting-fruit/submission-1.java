class Solution {
    public int orangesRotting(int[][] grid) {
        /*
        when a rotten fruit is reached, add 1 and change neighbors to rotten, and repeat for each neighbor
        - should do bfs because the fruits rot at the same time at each level
        - how to check if all fruits are rotten? (maybe recurse through again?)
        */
        /*
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    dfs(grid, visited, row, col, count);
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return count;
        */


        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) queue.offer(new int[]{row, col});
                if (grid[row][col] == 1) fresh++;
            }
        }

        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty() && fresh > 0) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }

        return fresh == 0 ? count : -1;
        
    }

    public void dfs(int[][] grid, boolean[][] visited, int row, int col, int count) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col]) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }

        visited[row][col] = true;
        if (grid[row][col] == 2 || grid[row][col] == 1) {
            dfs(grid, visited, row+1, col, count+1);
            dfs(grid, visited, row-1, col, count+1);
            dfs(grid, visited, row, col+1, count+1);
            dfs(grid, visited, row, col-1, count+1);
        }
        visited[row][col] = false;
    }
}
