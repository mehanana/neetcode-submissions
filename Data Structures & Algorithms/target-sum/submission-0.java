class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        /*
        for each number in nums, we can either add or subtract
          +1     -1
        +2 -2  +2 -2
        - if it equals target, return 1
        Hashmap<String, Integer>
        - string = +/- number, integer = sum?
        */
        return dfs(nums, target, 0, 0);
        
    }

    private int dfs(int[] nums, int target, int curSum, int index) {
        if (index == nums.length) {
            if (target == curSum) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = index + "," + curSum;
        if (memo.containsKey(key)) return memo.get(key);

        int res = dfs(nums, target, curSum + nums[index], index+1)
         + dfs(nums, target, curSum - nums[index], index+1);
        
        memo.put(key, res);
        return res;

    }
}
