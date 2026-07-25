class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        /*
        - instead of going through and seeing what to pop first, let's go through and see what value we'd get if it was popped last?
        - then you would've popped evrything to left & everythign to right before (left + right subarrays)
        - 
        */
        int[] padded = new int[nums.length+2];
        padded[0] = 1;
        padded[padded.length-1] = 1;
        for (int i = 1; i < padded.length-1; i++) {
            padded[i] = nums[i-1];
        }

        dp = new int[padded.length][padded.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(1, padded.length-2, padded);
        
    }

    private int dfs(int left, int right, int[] nums) {
        if (left > right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        dp[left][right] = 0;
        for (int i = left; i <= right; i++) {
            int coins = nums[left-1] * nums[i] * nums[right+1];
            coins += dfs(left, i-1, nums) + dfs(i+1, right, nums);
            dp[left][right] = Math.max(dp[left][right], coins);
        }
        return dp[left][right];
    }
}
