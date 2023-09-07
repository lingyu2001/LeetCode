class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        helper(0,0,n);
        return res;
    }
    
    public void helper(int m1, int m2, int n) {
        if(m1 == n && m2 == n) {
            res.add(sb.toString());
        } else if (m1 < m2) {
            return ;
        } else if (m1 <= n) {
            sb.append("(");
            helper(m1 + 1, m2, n);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            helper(m1, m2 + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            return ;
        }
    }
}