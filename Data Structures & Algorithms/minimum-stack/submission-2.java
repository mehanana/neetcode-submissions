class MinStack {
    private Stack<Integer> curList; // current list of values
    private Stack<Integer> minStack; // current list of values that stores in increasing order

    public MinStack() {
        curList = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        curList.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (minStack.isEmpty()) {
            return;
        }
        int top = curList.pop();
        if (top == minStack.peek()) {
            minStack.pop(); // pop from min stack if we're removing the min value
        }
    }
    
    public int top() {
        return curList.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
