class Solution {
    public int[] productExceptSelf(int[] nums) {
        // lets say nums = 1 2 4 6
        // result[] = _ _ _ _ --> 48, 24, 12, 8
        // result[0] = nums[1] * nums[2] * nums[3]
        // result[1] = nums[0] * nums[2] * nums[3]
        // result[2] = nums[0] * nums[1] * nums[3]
        // result[3] = nums[0] * nums[1] * nums[2]

        // org list {1 2 3 4}
        // pref {1, 2, 6, 24}
        // suff {24 24 12 4}
        // for each index, get the one before in pref and one after in suff and multiply

        
        int pre = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre = pre * nums[i];
        }
        int post = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = post * res[i];
            post = post * nums[i];
        }

        return res;
    }
}  
