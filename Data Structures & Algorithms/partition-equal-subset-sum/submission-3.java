class Solution {
    public boolean canPartition(int[] nums) {
        /*
        - if any subset sum = half of total sum, then return true
        */

        int goal = 0;
        for (int i : nums) {
            goal += i;
        }
        if (goal % 2 != 0) {
            return false;
        }

        goal = goal / 2;
        Boolean[][] memo = new Boolean[nums.length][goal + 1];

        return backtrack(nums, goal, 0, 0, memo);
    }

    private boolean backtrack(int[] nums, int goal, int i, int curSum, Boolean[][] memo) {
        if (curSum == goal) {
            return true;
        }
        if (i >= nums.length || curSum > goal) {
            return false;
        }
        if (memo[i][curSum] != null) {
            return memo[i][curSum];
        }
        boolean result = backtrack(nums, goal, i+1, curSum+nums[i], memo) 
                       || backtrack(nums, goal, i+1, curSum, memo);
        memo[i][curSum] = result;
        return result;
        
    }
}
