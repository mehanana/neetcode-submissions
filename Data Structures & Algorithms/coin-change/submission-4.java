class Solution {
    HashMap<Integer, Integer> dp = new HashMap();

    public int coinChange(int[] coins, int amount) {
        dp.put(0, 0);
        helper(coins, amount);
        return dp.get(amount);
    }

    public int helper(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }
        int min = Integer.MAX_VALUE;
        for (int a : coins) {
            int cur = helper(coins, amount-a);
            if (cur != -1) {
                min = Math.min(min, cur+1);
            }
        }
        if (min == Integer.MAX_VALUE) {
            dp.put(amount, -1);
        } else {
            dp.put(amount, min);
        }
        return dp.get(amount);
    }
}
