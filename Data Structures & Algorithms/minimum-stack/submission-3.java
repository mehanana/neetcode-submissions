class MinStack {
    /*
    - did not get it, but let's try coding after seeing hint
    */
    Stack<Integer> curStack;
    Stack<Integer> minStack;

    public MinStack() {
        curStack = new Stack();
        minStack = new Stack();
        
    }
    
    public void push(int val) {
        curStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }

        }
        
    }
    
    public void pop() {
        minStack.pop();
        curStack.pop();
    }
    
    public int top() {
        return curStack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
