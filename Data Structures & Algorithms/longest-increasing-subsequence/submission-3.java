class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        int max = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } else {
                    dp[i] = Math.max(1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
