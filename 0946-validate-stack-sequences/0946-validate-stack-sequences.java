class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int p1 = 0, p2 = 0;
        Stack<Integer> s = new Stack<>();
        while (p1 <= pushed.length && p2 <= popped.length - 1) {
            if (!s.isEmpty() && s.peek() == popped[p2]) {
                s.pop();
                p2++;
            } else {
                if (p1 == pushed.length) return false;
                s.push(pushed[p1]);
                p1++;
            }
        }
        return p2 >= popped.length;
    }
}