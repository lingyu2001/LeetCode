class Solution {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0);
        return res;
    }
    
    public void helper(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                path.add(s.substring(start, i + 1));
                helper(s, i + 1);
                path.removeLast();
            }
        }
    }
    
    public boolean isValid(String s, int left, int right) {
        if (right < left) return false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}