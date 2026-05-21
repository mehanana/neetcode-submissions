class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
        one two
        */
        int one = cost[0];
        int two = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = cost[i] + Math.min(one, two);
            one = two;
            two = temp;
        }
        return Math.min(one, two);
        
    }
}
