class Solution {
    StringBuilder sb = new StringBuilder();
    LinkedList<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0);
        return res;
    }

    public void helper(int n, int l, int r) {
        if (l > n || l < r || r > n) return ;
        if (l == n && r == n) {
            res.add(sb.toString());
            return ;
        }
        if (l < n) {
            sb.append("(");
            helper(n, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < n) {
            sb.append(")");
            helper(n, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}