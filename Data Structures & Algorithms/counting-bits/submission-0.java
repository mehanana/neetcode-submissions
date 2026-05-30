class Solution {
    public int[] countBits(int n) {
        /*
        - keep moding by 2
        */

        int[] dp = new int[n + 1];
        int offset = 1; // most significant bit (1, 2, 4, 8, etc.)

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
        
    }
}
