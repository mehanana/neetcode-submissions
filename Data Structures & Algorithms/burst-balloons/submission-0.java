public class Solution {
    public int maxCoins(int[] nums) {
        /*
        brute force:
        - pop one of the choices, repeat twith the next choice, etc. like backtracking

        subproblem:
        [3 1 5 8]
        - pop 5 --> subproblem = [3 1 8]
        - pop 1 & then 8 --> [3 5]
        - as we pop, we get a subsequence
        - for each value, we choose to include or not include, so here's 2^n subproblems (inefficient)

        - let's say we pop 5, we get 2 subarrays [3 1] & [8]
        - for input size n, there's n^2 subarrays max
        - so each subarray is its own subproblem, but when trying to find the cost, we need to use both subarrays at once
         - eg. [3 1] & [8] --> for calculating cost at 1, we have to do 3 * 1 * 8, so we need both subarrays
        
        - let's say 5 is the last thing we pop
        - this means the cost at 5 is 1 * 5 * 1
        - now if we compare the two subarrays, we can pop independently since they'll never be connected
        [3 1] & 5 (popped) & [8]
        - cost at 1 now is 3 * 1 * 5(need to remember this), then pop at 3 to get 1 * 3 * 1
        - implicit '1' next to the edges
        - this is our subproblem !!

        dp[LeftBoundary][RightBoundary]
        */
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1; // first and last index is 1
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(newNums, 1, newNums.length - 2, dp);
    }

    public int dfs(int[] nums, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        dp[l][r] = 0;
        for (int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, l, i - 1, dp) + dfs(nums, i + 1, r, dp);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}