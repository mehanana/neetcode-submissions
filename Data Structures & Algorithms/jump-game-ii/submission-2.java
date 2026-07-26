class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < nums.length-1) {
            int cur = left;
            for (int i = left; i <= right; i++) {
                cur = Math.max(cur, i + nums[i]);
            }
            left = right+1;
            right = cur;
            res++;
        }
        return res;
























        /*
        - find the range of jumps we can make from each position
        - once the farthest value is in the range, move on
            - we move onto the right val + 1
            - set right to the farthest val we can reach (since that's the cur range)
        */
        /*
        int res = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
        */
        
    }
}
