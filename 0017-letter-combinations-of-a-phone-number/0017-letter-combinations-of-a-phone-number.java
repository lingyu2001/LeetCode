class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] strs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        helper(digits, 0);
        return res;
    }

    public void helper(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            String s = strs[digits.charAt(i) - '0'];
            for (int j = 0; j < s.length(); j++) {
                sb.append(s.charAt(j));
                helper(digits, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}