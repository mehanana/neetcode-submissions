class Solution {
    public int numIslands(char[][] grid) {
        /*
        - when we find a 1, we increase count by 1 & do dfs around neighbors and mark visited as 0
        - go through each cell and repeat
        - return count
        */
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(row, col, grid);
                }
            }
        }
        
        return count;
        
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = '0';
            dfs(row+1, col, grid);
            dfs(row-1, col, grid);
            dfs(row, col+1, grid);
            dfs(row, col-1, grid);
        }
    }
}
