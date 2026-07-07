class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        // Each entry: {value, row, col} — ordered by value ascending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curVal = cur[0], row = cur[1], col = cur[2];

            // Stale entry — a better path to this cell was already finalized
            if (curVal > dist[row][col]) {
                continue;
            }

            if (row == n - 1 && col == n - 1) {
                return curVal;
            }

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                int newVal = Math.max(curVal, grid[nr][nc]);
                if (newVal < dist[nr][nc]) {
                    dist[nr][nc] = newVal;
                    pq.offer(new int[]{newVal, nr, nc});
                }
            }
        }

        return dist[n-1][n-1];
    }
}