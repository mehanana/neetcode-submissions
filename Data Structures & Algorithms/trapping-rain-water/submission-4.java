class Solution {
    public int trap(int[] height) {
        /*
        - arghh dk how to do
        - go until you reach val >= 0 --> this is cur height
        - then, keep going until you reach val > curheight
        - calc how much water trapped
        - now the new val is curheight, repeat until end reached
        - only add if there's a right boundary



        other way to think about this is that the water at any bar is the Math.min(max left, max right) - heights[i]
        - find the max heights of everything before i and the max heights of everything after i
        - then go through once again and find the max water held and return result
        */

        int[] pre = new int[height.length];
        pre[0] = 0;
        for (int i = 1; i < height.length; i++) {
            pre[i] = Math.max(height[i-1], pre[i-1]);
        }
        int[] post = new int[height.length];
        post[height.length-1] = 0;
        for (int i = height.length-2; i >= 0; i--) {
            post[i] = Math.max(height[i+1], post[i+1]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.max(0, Math.min(pre[i], post[i]) - height[i]);
        }
        return res;

    }
}
