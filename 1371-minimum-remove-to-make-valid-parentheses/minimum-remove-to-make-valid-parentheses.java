class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] sb = new char[s.length()];
        sb = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    sb[i] = ' ';
                } else {
                    stack.pop();
                }
            } 
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            sb[idx] = ' ';
        }
        StringBuilder res = new StringBuilder();
        int p = 0;
        while (p < sb.length) {
            if (sb[p] == ' ') {p++; continue;}
            res.append(sb[p]);
            p++;
        }
        return res.toString();
    }
}