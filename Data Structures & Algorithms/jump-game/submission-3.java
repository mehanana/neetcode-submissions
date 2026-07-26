class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n-1;

        for (int i = n-2; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }
        return goal == 0;






























        /*
        int goal = nums.length-1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (goal - i <= nums[i]) {
                goal = i;
            }
        }
        return goal == 0;
        */
        
    }
}
