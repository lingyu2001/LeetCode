class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int t2 = s.pop();
                int t1 = s.pop();
                s.push(t1 + t2);
            } else if (tokens[i].equals("*")) {
                int t2 = s.pop();
                int t1 = s.pop();
                s.push(t1 * t2);
            } else if (tokens[i].equals("/")) {
                int t2 = s.pop();
                int t1 = s.pop();
                s.push(t1 / t2);
            } else if (tokens[i].equals("-")) {
                int t2 = s.pop();
                int t1 = s.pop();
                s.push(t1 - t2);
            } else {
                // integers
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.peek();
    }
}