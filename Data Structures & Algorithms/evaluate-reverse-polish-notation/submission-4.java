class Solution {
    public int evalRPN(String[] tokens) {
        /*
        - stack that keeps track of inputs
        - once you reach an operation, perform that operation on the numbers in the stack (and remove them from the stack)
        - then add the result into the stack
        - return result at the end
        */

        Stack<Integer> items = new Stack<>();

        for (String s: tokens) {
            if (s.equals("+")) {
                if (!items.isEmpty()) {
                    int start = items.pop();
                    int count = 1;
                    while (!items.isEmpty() && count < 2) {
                        start += items.pop();
                        count++;
                    }
                    items.push(start);
                }
            } else if (s.equals("-")) {
                if (!items.isEmpty()) {
                    int start = items.pop();
                    int count = 1;
                    while (!items.isEmpty() && count < 2) {
                        start -= items.pop();
                        count++;
                    }
                    items.push(0-start);
                }
            } else if (s.equals("*")) {
                if (!items.isEmpty()) {
                    int start = items.pop();
                    int count = 1;
                    while (!items.isEmpty() && count < 2) {
                        start *= items.pop();
                        count++;
                    }
                    items.push(start);
                }
            } else if (s.equals("/")) {
                if (!items.isEmpty()) {
                    int start = items.pop();
                    int count = 1;
                    while (!items.isEmpty() && count < 2) {
                        start = items.pop() / start;
                        count++;
                    }
                    items.push(start);
                }
            } else {
                items.push(Integer.parseInt(s));
            }
        }

        return items.pop();
        
    }
}
