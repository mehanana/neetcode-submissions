class Solution {
    public int maxProduct(int[] nums) {
        /*
        two pointer
        go until you find neg number
        if there's no more neg numbers, then start at the index after the last neg number and see if the product of everything after that is greater or not

        this is kinda like the longest palindrome then? start at each number, extend outward in both directions and see if the product increases, if it ever decreases, then restart?
        */

        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }
        return res;
        
    }
}
