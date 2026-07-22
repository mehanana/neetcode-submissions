class Solution {
    private Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        /*
        backtrack way:
        - buy or sell
        - if buy, go to next day
        - if sell, go to next next day
        - do nothing

        cache:
        key: index, boolean (buy, sell)


        */

        return dfs(0, true, prices);
        
    }

    private int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "-" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        
        if (buying) {
            int buy = dfs(i+1, false, prices) - prices[i];
            int cool = dfs(i+1, true, prices);
            dp.put(key, Math.max(buy, cool));
        } else {
            int sell = dfs(i+2, true, prices) + prices[i];
            int cool = dfs(i+1, false, prices);
            dp.put(key, Math.max(sell, cool));
        }

        return dp.get(key);

    }
}
