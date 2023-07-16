class Solution {
    public String removeStars(String s) {
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (s1.isEmpty()) continue;
                else s1.pop();
            } else {
                s1.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty()) {
            sb.append(s1.pop());
        }
        return sb.reverse().toString();
    }
}