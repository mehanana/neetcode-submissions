class Solution {
    public int change(int amount, int[] coins) {
        /*
        coins[0] -> either go to coins[0] again or move to coins[1] with target = amount - coins[0]
        if target == 0, add 1
        */
        HashMap<String, Integer> memo = new HashMap<>();
        return dfs(amount, coins, 0, memo);
    }

    private int dfs(int target, int[] coins, int index, HashMap<String, Integer> memo) {
        if (target == 0) return 1;
        if (index >= coins.length || target < 0) return 0;
        
        String key = target + "," + index;
        if (memo.containsKey(key)) return memo.get(key);
        
        int res = dfs(target - coins[index], coins, index, memo)   // use coin
                + dfs(target, coins, index + 1, memo);              // skip coin
        memo.put(key, res);
        return res;
    }
}
