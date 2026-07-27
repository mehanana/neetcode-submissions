class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // first check if the total gas is greater than total cost, which means 1 path exists
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (costSum > gasSum) {
            return -1;
        }

        int curTotal = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            curTotal += gas[i] - cost[i];
            if (curTotal < 0) {
                curTotal = 0;
                res = i+1;
            }
        }
        return res;





















        /*
        if totalgas - cost[i] < 0 -> cant move to i+1
        totalgas = totalgas + gas[i]

        brute force = try at every index
            - but if we ever reach neg, then restart at current index
        */
        /*

        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int total = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i+1;
            }
        }
        return res; 
        */


        
    }
}
