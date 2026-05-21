class Solution {
    public int rob(int[] nums) {
        /*
        [1 1 3 3]

        start at index 0 -> can go to index 2, 3
        at index 2 -> the end
        at index 3 -> the end

        start at index 1 -> can go to index 3
        at index 3 -> the end

        - start at 1st house & 2nd house
        - skip the neighbor
        */

        if (nums.length == 1) {
            return nums[0];
        }

        int one = nums[0];
        int two = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(nums[i] + one, two);
            one = two;
            two = temp;
        }
        return Math.max(one, two);
        
    }
}
