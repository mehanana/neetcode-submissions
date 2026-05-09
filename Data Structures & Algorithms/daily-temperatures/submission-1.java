class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        we have a stack that stores temperatures
        - look at first temp -> 30 and add to stack
        - look at next temp -> 38; if it's greater than the current top temp, store stack.length() in int[] and pop from stack and add current value to stack
         -  if it's not greater than current top temp, add to stack and move to next val
        
        Instead of storing the temp though, let's store the indexes. then when we find a warmer date, we do curIndex - indexStored
        */
        int[] result = new int[temperatures.length];
        for (int i : result) {
            result[i] = 0;
        }

        Stack<Integer> indexes = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!indexes.isEmpty() && temperatures[i] > temperatures[indexes.peek()]) {
                int toStore = indexes.pop();
                result[toStore] = i - toStore;
            }
            
            indexes.push(i);
        }

        return result;
    }
}
