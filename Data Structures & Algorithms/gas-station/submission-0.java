class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        at each station i, add the gas[i] to curGas and see if it's greater than or equal to cost
        if yes, then go to that station and repeat
        - if you end up back at i, return i
        if no, then go to the next station and repeat
        - if you go through all stations and none have enough gas, return -1
        */
        /*

        for (int i = 0; i < gas.length; i++) {
            int curGas = gas[i] - cost[i];
            if (curGas >= 0) {
                if (dfs(gas, cost, i+1, i, curGas)) {
                    return i;
                }
            }
        }
        return -1;
        */

        /*
        greedy:
        - at each stop, see if the totalGas (gas[i] - cost[i]) is pos or neg
        - if it's neg, then the start index has to be after i
        */

        // no solution = total gas < total cost
        int totalGas = 0;
        for (int i : gas) {
            totalGas += i;
        }

        int totalCost = 0;
        for (int i : cost) {
            totalCost += i;
        }
        if (totalGas < totalCost) {
            return -1;
        }

        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return start;
    }

    private boolean dfs(int[] gas, int[] cost, int index, int startIndex, int curGas) {
        while (index != startIndex) {
            if (index == gas.length) {
                index = 0;
            }
            curGas += gas[index] - cost[index];
            if (curGas < 0) {
                return false;
            }
            index++;
        }
        return true;
    }
}
