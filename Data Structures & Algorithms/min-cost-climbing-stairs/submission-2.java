class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int last = cost.length - 1;

        int first = cost[last]; // 3
        int second = cost[last-1]; // 2

        int cur = last-2;

        while (cur >= 0) {
            int temp = second;
            second = cost[cur] + Math.min(second, first);
            first = temp;
            cur--;
        }
        return Math.min(first, second);
        
    }
}
