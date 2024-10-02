class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else if (s.charAt(i) == ')') {
                if (stack.size() == 0) {
                    sb.setCharAt(i, ' ');
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            int i = stack.pop();
            sb.setCharAt(i, ' ');
        }
        int i = 0, p = 0;
        while (p < sb.length()) {
            if (sb.charAt(p) != ' ') {
                sb.setCharAt(i++, sb.charAt(p));
            } 
            p++;
        }
        return sb.substring(0,i).toString();
    }
}