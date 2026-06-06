class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        [30 38 30 36 35 40 28]
       - store indexes in stack and check for all values in stack until curTemp > temperature[i from stack]

        */
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }

        return res;
        
    }
}
