class Solution {
    public int evalRPN(String[] tokens) {
        // iterate the tokens
            // s = currrent token
            // if s is operation
                // pop the element twice, and get the elements as a and b
                // result = b operation a
                // add result to stack
            // if s is not operation
                // add the token to stack
        // end 
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            int result = 0;
            if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                result = b + a;
                stack.add(result);
            } else if (s.equals("-"))  {
                int a = stack.pop();
                int b = stack.pop();
                result = b - a;
                stack.add(result);
            } else if (s.equals("/"))  {
                int a = stack.pop();
                int b = stack.pop();
                result = b / a;
                stack.add(result);
            } else if (s.equals("*"))  {
                int a = stack.pop();
                int b = stack.pop();
                result = b * a;
                stack.add(result);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}