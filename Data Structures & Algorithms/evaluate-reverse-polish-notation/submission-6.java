class Solution {
    public int evalRPN(String[] tokens) {
        /*
        - stack that keeps track of inputs
        - once you reach an operation, perform that operation on the numbers in the stack (and remove them from the stack)
        - then add the result into the stack
        - return result at the end
        */

        Stack<Integer> stack = new Stack<>();

        for (String s: tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(0 - (stack.pop() - stack.pop()));
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
        
    }
}
