class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int top;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        top = -1;
    }

    public void push(int x) {
        if (stack2.empty()) top = x;
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        int ret = -1;
        if (!stack2.empty())  ret = stack2.pop();
        if (!stack2.empty()) {
            top = stack2.pop();
            stack2.push(top);
        }
        return ret;
    }

    public int peek() {
        return top;
    }

    public boolean empty() {
        return stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */