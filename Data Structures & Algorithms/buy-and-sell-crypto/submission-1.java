class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int res = 0;
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
            } else {
                res = Math.max(res, prices[right] - prices[left]);
            }

            right++;


        }
        return res;
    }
}
