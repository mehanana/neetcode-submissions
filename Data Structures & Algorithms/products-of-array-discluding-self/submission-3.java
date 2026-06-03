class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        pre array -> contains the products of everything before index
        suf array -> contians the products of everything after index
        - then for index i, we multiple pre[i] * suf[i] because that's everything except for i
        */

        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        pre[0] = 1;
        suf[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i-1] * pre[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            suf[i] = suf[i+1] * nums[i+1];
            pre[i] = pre[i] * suf[i];
        }
        return pre;

























        /*
        [1 2 4 6]
        [1 1 2 8] (exclude cur number)
        [48 24 6 1]
        - then multiply 

        [48 24 12 8]
        */
/*
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }
        int[] suf = new int[nums.length];
        suf[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suf[i] = suf[i+1] * nums[i+1];
            pre[i] = pre[i] * suf[i];
        }
        return pre;
        */
    }
}  
