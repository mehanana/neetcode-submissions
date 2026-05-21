class Solution {
    public int rob(int[] nums) {
        /*
        this time, houses are in a circle, so first and last are neighbors
        - think we just stop one house before end?
        */
        if (nums.length == 1) return nums[0];

        int rob1 = 0, rob2 = 0;

        for (int i = 0; i < nums.length-1; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        int curMax = Math.max(rob1, rob2);

        rob1 = 0;
        rob2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return Math.max(curMax, Math.max(rob1, rob2));
        
    }
}
