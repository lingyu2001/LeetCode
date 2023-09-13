class Solution {
    Stack<Character> stack = new Stack<>();
    String res = "";
    public String decodeString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') stack.push(c);
            else {
                String newS = "";
                while (stack.peek() != '[') {
                    newS = stack.pop() + newS;
                }
                stack.pop(); // '['
                // System.out.println(newS);
                String num = "";
                while (!stack.isEmpty() && stack.peek() <= '9' && stack.peek() >= '0') num = stack.pop() + num;
                int time = Integer.parseInt(num);
                String ss  = new String(newS);
                for (int j = 0; j < time - 1; j++) {
                    ss += newS;
                }
                if (stack.isEmpty()) {
                    res += ss;
                } else {
                    for (int j = 0; j < ss.length(); j++) {
                        stack.push(ss.charAt(j));
                    }
                }
            }
        }
        String rest = "";
        while (!stack.isEmpty()){
            rest = stack.pop() + rest;
        }
        return res + rest;
    }
}