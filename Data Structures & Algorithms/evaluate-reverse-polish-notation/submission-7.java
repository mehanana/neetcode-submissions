class Solution {
    public int evalRPN(String[] tokens) {
        /*
        - add values to stack
        - if operation reached, pop top 2 and do operation
        - store in stack
        - at end, return top of stack
        */

        Stack<Integer> stack = new Stack();
        for (String s : tokens) {
            if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);

            } else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);

            } else if (s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);

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
