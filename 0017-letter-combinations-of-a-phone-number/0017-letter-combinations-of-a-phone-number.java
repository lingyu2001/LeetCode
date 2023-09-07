class Solution {
    LinkedList<String> res = new LinkedList<>();
    String[] strs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return res;
        helper(digits, 0);
        return res;
    }
    
    public void helper(String digits, int start){
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return ;
        }
        for (int i = start; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            for (char c : strs[num].toCharArray()) {
                sb.append(c);
                helper(digits, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}