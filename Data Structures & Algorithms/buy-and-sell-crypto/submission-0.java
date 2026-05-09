class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        /*
        - start at index 0
        - look at index 1, if it's decreasing, move index 0 to index 1
        - look at index 2, if it's increasing, store the cur profit and move up again
        - look at index 3, it's increasing, check the curProfit and see if it's more than the maxProf, if so, store it
        - repeat until done
        */
        int left = 0;
        int right = 1;
        while (left < right && right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            } else {
                profit = Math.max(profit, prices[right] - prices[left]);
                right++;
            }
        }


        return profit;
    }
}
