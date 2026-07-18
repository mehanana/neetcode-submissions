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

        return backtrack(nums, goal, 0, 0);
    }

    private boolean backtrack(int[] nums, int goal, int i, int curSum) {
        if (curSum == goal) {
            return true;
        }
        if (i >= nums.length || curSum > goal) {
            return false;
        }
        if (backtrack(nums, goal, i+1, curSum+nums[i]) || backtrack(nums, goal, i+1, curSum)) {
            return true;
        }
        return false;
        
    }
}
