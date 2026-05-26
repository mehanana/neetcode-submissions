class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        /*
        word1 == word2 : return 0
        word1 is not empty and word2 is empty --> just delete all characters
        if (word1.charAt(i) == word2.charAt(j)) {
        repeat with i+1, j+1 (move to next letter for each word)
        } else {
        try insert, delete, and replace
        - keep track of how many times you're doing operations
        }
        insert -> i, j+1
        delete -> i+1, j
        replace -> i+1, j+1
        */
        int m = word1.length(), n = word2.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, word1, word2, m, n);
    }

    private int dfs(int i, int j, String word1, String word2, int m, int n) {
        if (i == m) {
            return n-j;
        }
        if (j == n) {
            return m - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = dfs(i+1, j+1, word1, word2, m, n);
        } else {
            int res = Math.min(dfs(i+1, j, word1, word2, m, n),
                                dfs(i, j+1, word1, word2, m, n)
            );
            res = Math.min(res, dfs(i+1, j+1, word1, word2, m, n));
            dp[i][j] = res + 1;
            
        }
        return dp[i][j];
    }
}
