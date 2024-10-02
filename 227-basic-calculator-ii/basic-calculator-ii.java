class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll("\\s+", "");
        int p = 0;
        int num = 0;
        char sign = '+';
        while (p < s.length()) {
            if (s.charAt(p) >= '0' && s.charAt(p) <= '9') {
                num = num * 10 + s.charAt(p) - '0';
            } 
            // find the last sign before this character
            if (!Character.isDigit(s.charAt(p)) || p == s.length() - 1) {
                if (sign == '+') {
                    stack.add(num);
                } else if (sign == '-') {
                    stack.add(-num);
                } else if (sign == '*') {
                    stack.add(stack.pop()*num);
                } else if(sign == '/'){
                    stack.add(stack.pop()/num);
                }
                sign = s.charAt(p);
                num = 0;
            }
            p++;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}