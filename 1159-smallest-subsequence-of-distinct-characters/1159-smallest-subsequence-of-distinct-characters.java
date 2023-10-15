class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        for (char c : s.toCharArray()) {
            cnt[c]--;
            if (inStack[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c) {
                if (cnt[stack.peek()] == 0) {
                    break;
                } else {
                    inStack[stack.pop()] = false;
                }
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}