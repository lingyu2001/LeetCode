class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char top = ' ';
                if (stack.isEmpty()) {
                    return false;
                } else {
                    top = stack.pop();
                }
                if (c == ']' && top != '[') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                } else if (c == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}