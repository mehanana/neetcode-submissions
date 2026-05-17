class Solution {
    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    dfs(grid, visited, row, col, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col, int dist) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if (visited[row][col]) return;
        if (grid[row][col] == -1) return;
        if (dist > grid[row][col]) return;  // already have a shorter path

        grid[row][col] = dist;
        visited[row][col] = true;
        dfs(grid, visited, row+1, col, dist+1);
        dfs(grid, visited, row-1, col, dist+1);
        dfs(grid, visited, row, col+1, dist+1);
        dfs(grid, visited, row, col-1, dist+1);
        visited[row][col] = false;
    }
}