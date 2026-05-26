class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        /*
        brute force
        - go through each cell
        - check left, right, up, down (if exists)
        - repeat same steps for the cells that are greater than the current one
        - keep track of how many times you do this dfs
        - once you can't go anywhere else, if the length is greater than the prev max, store this length
        - don't need to keep track of visited since you can only increase

        - cache the longest path at each position3
        */
        int ROWS = matrix.length, COLS = matrix[0].length;
        int LIP = 0;
        dp = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dp[i][j] = -1;
            }
        }
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                LIP = Math.max(LIP, dfs(matrix, r, c, Integer.MIN_VALUE));
            }
        }
        return LIP;
        
       
    }
    private int dfs(int[][] matrix, int r, int c, int prevVal) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        if (r < 0 || r >= ROWS || c < 0 ||
            c >= COLS || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != -1) return dp[r][c];

        int res = 1;
        for (int[] d : directions) {
            res = Math.max(res, 1 + dfs(matrix, r + d[0],
                                    c + d[1], matrix[r][c]));
        }
        return dp[r][c] = res;
    }
}
