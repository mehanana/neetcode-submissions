class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        /*
        - go through each cell
        - if it's a 1, dfs and add to count
        - save curcount as max of curcount & this new value
        - return curcount at the end
        */
        int maxCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxCount = Math.max(dfs(row, col, grid), maxCount);
                }
            }
        }
        return maxCount;
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 + dfs(row+1, col, grid) + dfs(row-1, col, grid) + dfs(row, col+1, grid) + dfs(row, col-1, grid);
    }
}
