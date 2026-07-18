class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int n : nums) {
            int temp = curMax;
            curMax = Math.max(n, Math.max(n * curMax, n * curMin));
            curMin = Math.min(n, Math.min(n * temp, n * curMin));
            res = Math.max(res, curMax);
        }

        return res;
        
    }
}
