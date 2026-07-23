class Solution {
    HashMap<String, Integer> valToNum = new HashMap(); // val + index to num
    public int change(int amount, int[] coins) {
        /*
     amount 5 4 3 2 1 0
coins
        1         2 1 1
        2         1 0 1
        5   0 0 0 0 0 1
        */
        /*
    hashmap - Integer to Integer (value to numWays to make that value)
        */
        return calcWays(coins, amount, 0, 0);
        
    }

    private int calcWays(int[] coins, int target, int amount, int i) {
        if (amount == target) {
            return 1;
        }
        if (amount > target) {
            return 0;
        }
        if (i == coins.length) {
            return 0;
        }
        String key = amount + ", " + i;
        if (valToNum.containsKey(key)) {
            return valToNum.get(key);
        }
        valToNum.put(key, calcWays(coins, target, amount+coins[i], i) + calcWays(coins, target, amount, i+1));
        return valToNum.get(key);
    }
}
