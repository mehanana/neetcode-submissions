class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> dp = new HashMap<>();
        return dfs(0, true, dp, prices);
    }

    private int dfs(int i, boolean buying, HashMap<String, Integer> dp, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "," + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res;
        if (buying) {
            int buy = dfs(i + 1, false, dp, prices) - prices[i];
            int cooldown = dfs(i + 1, true, dp, prices);
            res = Math.max(buy, cooldown);
        } else {
            int sell = dfs(i + 2, true, dp, prices) + prices[i];
            int cooldown = dfs(i + 1, false, dp, prices);
            res = Math.max(sell, cooldown);
        }
        dp.put(key, res);
        return res;
    }
}