class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        - can either choose current one again or move to the next one or skip
        so maybe one, two, three variables?

        - pick one coin, then solve subproblem of amount-coin, then take min of all solutions
            - explore all the combos tho
        
        - bottom up = start at min total amount and build up to amount
        [1 3 4 5]
        dp[0] = 0 coins
        dp[1] = 1 coin (val = 1)
        dp[2] = 2 coin (1 1) --> 1 + dp[1]
        dp[3] = 1 coin (3)
        dp[4] = 1 coin (4)
        dp[5] = 1 coin (5)
        dp[6] = 2 coin (3 3)
        dp[7] = 2 coin (3 4)

        - 
        */

/*
        int res = dfs(coins, amount);
        
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
        */

        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount+1;
        }

        for (int a = 1; a < amount+1; a++) {
            for (int c : coins) {
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a-c]);
                    /*
                    coin = 4
                    a = 7
                    dp[7] = 1 + dp[3]
                    */
                }
            }
        }

        if (dp[amount] == amount+1) {
            return -1;
        }
        return dp[amount];


        
    }

    public int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int c : coins) {
            if (amount - c >= 0) {
                int cur = dfs(coins, amount - c);
                if (cur != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + cur);
                }
            }
        }
        return res;
    }
}
