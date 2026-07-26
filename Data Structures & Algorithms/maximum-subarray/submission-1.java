class Solution {
    public int maxSubArray(int[] nums) {
        /*
        - start at index 0
        - keep going right
        - if the sum ever decreases, store cur max sum, move the start pointer to the cur place & keep going
        */

        int max = nums[0];
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += nums[i];
            max = Math.max(max, curSum);
            
        }
        return Math.max(max, curSum);
    }
}
