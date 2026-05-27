class Solution {
    public int maxSubArray(int[] nums) {
        /*
        i think if the solution ever drops into the negatives, we move on?
        [4 -5 100]
        - no matter what, the subarray [100] will be greater than [4 -5 100] since by adding a neg. value, we'll be making 100 smaller
        -1
        */

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += i;
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;

        
    }
}
