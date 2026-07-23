class Solution {
    HashMap<String, Integer> memo = new HashMap(); // num + sign to number of ways to get there?
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int curSum, int i) {
        if (i >= nums.length) {
            if (target == curSum) {
                return 1;
            }
            return 0;
        }

        String key = i + "," + curSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = dfs(nums, target, curSum + nums[i], i + 1)
                 + dfs(nums, target, curSum - nums[i], i + 1);
        return ways;
    }
}
