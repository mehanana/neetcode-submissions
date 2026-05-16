class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxCount = Math.max(maxCount, dfs(grid, row, col));
                }
            }
        }

        return maxCount;
        
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + dfs(grid, row+1, col) + dfs(grid, row-1, col) + dfs(grid, row, col+1) + dfs(grid, row, col-1);
        }
        return 0;
    }
}
