class Solution {
    public int uniquePaths(int m, int n) {
        /*
        move down or right
        for each square, max 2 possible moves
        [m][n]
        - for each cell, keep track of total possible moves to the trophy (work backwards)
        - to get the total possible moves of this cell, we add the possible moves from cell to right and cell down (if they exist)
        */

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        // last row — can only go right
        for (int col = 0; col < n; col++) dp[m-1][col] = 1;
        // last col — can only go down
        for (int row = 0; row < m; row++) dp[row][n-1] = 1;

        
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >=0; col--) {
                dp[row][col] = dp[row][col+1] + dp[row+1][col];
            }
        }
        return dp[0][0];
    }
}
