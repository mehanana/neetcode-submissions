class Solution {
    public int jump(int[] nums) {
        /*
        well we know greedy solution now, so maybe take max steps back?
        
        start at index 0
        - see the range of the nums[0]
        go to index 1
        - see the range of nums[1] and if any is out of range from nums[0]
        */
        int res = 0, l = 0, r = 0;

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
    }
}
