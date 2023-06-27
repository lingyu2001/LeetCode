class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        top = -1;
    }

    public void push(int x) {
        top = x;
        q1.offer(x);
    }

    public int pop() {
        if (q1.size() == 0) return -1;
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int ret = q1.poll();
        // move elements from q2 to q1;
        while (!q2.isEmpty()) {
            top = q2.poll();
            q1.offer(top);
        }
        return ret;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */