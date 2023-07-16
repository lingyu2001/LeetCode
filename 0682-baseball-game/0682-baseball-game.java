class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            String s1 = operations[i];
            if (s1.equals("C")) {
                s.pop();
            } else if (s1.equals("D")) {
                s.push(2 * s.peek());
            } else if (s1.equals("+")) {
                int t1 = s.pop();
                int t2 = s.pop();
                s.push(t2);
                s.push(t1);
                s.push(t1 + t2);
            } else {
                s.push(Integer.parseInt(s1));
            }
        }
        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }
}