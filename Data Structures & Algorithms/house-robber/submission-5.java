class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        
        int last = nums[nums.length-1];
        int secondLast = Math.max(nums[nums.length - 1], nums[nums.length - 2]);

        int curHouse = nums.length-3;
        while (curHouse >= 0) {
            int newVal = Math.max(secondLast, nums[curHouse] + last);
            last = secondLast;
            secondLast = newVal;
            curHouse--;
        }

        return secondLast;
    }
}
