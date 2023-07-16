class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        helper(n, 0,0);
        return res;
    }
    
    public void helper(int n, int m1, int m2) {
        if (m1 == n && m2 == n) {
            res.add(new String(sb.toString()));
            return;
        } else if (m1 < m2) {
            return ;
        } else if (m1 <= n){
            sb.append("(");
            helper(n, m1 + 1, m2);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            helper(n, m1, m2 + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            return;
        }
    }
}