class Solution {
    public int trap(int[] height) {
        /*
        - to find the amount of water trapped at i, find the max before i and the max after i and do Math.min(prefix, suffix) - height[i]
        [1 5 2 3 4]
        pre array [0 1 5 5 5]
        suf array [5 4 4 4 0]
        */

        int[] pre = new int[height.length];
        int[] suf = new int[height.length];
        pre[0] = 0;
        suf[height.length-1] = 0;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = Math.max(pre[i-1], height[i-1]);
        }
        for (int i = pre.length-2; i >= 0; i--) {
            suf[i] = Math.max(suf[i+1], height[i+1]);
        }
        int res = 0;
        for (int i = 0; i < pre.length; i++) {
            res += Math.max(0, Math.min(pre[i], suf[i]) - height[i]);
        }
        return res;
    }
}
