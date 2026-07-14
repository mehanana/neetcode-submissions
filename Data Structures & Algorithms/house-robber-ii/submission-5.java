class Solution {
    public int rob(int[] nums) {
        /*
        - if you include 1st house, can only rob until n-2 houses
        - if you don't include 1st house, can rob from 1 to n-1 houses
        */

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length-1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
       }

       private int helper(int[] nums) {
        int rob1 = nums[nums.length-1];
        int rob2 = Math.max(rob1, nums[nums.length-2]);

        int index = nums.length - 3;
        while (index >= 0) {
            int temp = rob2;
            rob2 = Math.max(nums[index] + rob1, rob2);
            rob1 = temp;
            index--;
        }
        return rob2;
       }

    
}
