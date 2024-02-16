class MinStack {
    // 1. create 2 stacks
    Stack<Long> s1;
    Stack<Long> s2;
    long min;
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        s1.push((long)val);
        min = Math.min(min,(long)val);
        s2.push(min);
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
        if (!s2.isEmpty()) {
            min = s2.peek();
        } else min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return s1.peek().intValue();
    }
    
    public int getMin() {
        return s2.peek().intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */