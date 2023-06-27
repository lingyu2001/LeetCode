class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 == 1) return false;
        for (int i = 0; i < s.length(); i++) {
            // ),] }: pop an element and see if the element can match the character
            if (!map.containsKey(s.charAt(i))) {
                if (stack.empty()) return false;
                char c = stack.pop();
                // do not match
                if (map.get(c) != s.charAt(i)) return false;
            } else {
                // (,{,[: add to the stack
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}