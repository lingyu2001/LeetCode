class Solution {
    public int evalRPN(String[] tokens) {
        // 0. define a variable called res.
        // 1. iterate each token in the array 
        // 1.1 if it is a number? => push it to the stack
        // 1.2 if it is an operator => pop twice -> a,b and then do the calculation, push the result to the stack
        // 2. return the result

        // edge case: if the stack is empty?
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        for (String s : tokens) {
            if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                n = a + b;
            } else if(s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                n = b - a;
            }else if(s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                n = a * b;
            } else if(s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                n = b / a;
            } else {
                n = Integer.parseInt(s);
            }
            stack.push(n);
        }
        return stack.peek();
    }
}