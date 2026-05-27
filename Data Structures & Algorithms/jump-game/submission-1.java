class Solution {
    public boolean canJump(int[] nums) {
        /*
        [1 2 0 1 0]
        i   0 1 3 4 (the end)
        val 1 2 1

        [1 2 1 0 1]
        i   0 1 3 (can't go anywhere)
        val 1 2 0

        - nums[index] is the MAX jump length

        [3 2 1 0 4]
        - start at pos 0, look at value (3)
            - can jump 1, 2, or 3
        - values at these places are 2, 1, 0 at index 1 2 3
        - don't want 0
        - from 1 & 2, we can go to index 2 or 3 (since max 2 jumps)

        dp:
        boolean[] cache
        for (int i = i-2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        - at this index, can we reach the end (bottom to top)

        greedy:
        - start at end and see if we can reach beginning
        [2 3 1 1 4]
        goal = nums.length - 1;
        - at nums.length - 2, the value is 1, and this can reach the end position, so now, the goal is nums.length - 2 (because we just need to reach this position)


        */

        int goal = nums.length-1;
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] + index >= goal) {
                goal = index;
            }
            index--;
        }
        return goal == 0;
        
    }
}
