class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    sb.setCharAt(i, ' ');
                } else {
                    stack.pop();
                }
            } 
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            sb.setCharAt(idx, ' ');
        }
        return sb.toString().replaceAll("\\ ", "");
    }
}