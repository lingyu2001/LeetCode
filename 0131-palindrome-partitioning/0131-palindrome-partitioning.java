class Solution {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0, s.length() - 1);
        return res;
    }
    
    public void helper(String s, int start, int end) {
        if (start > end) {
            res.add(new ArrayList<>(path)) ;
            return ;
        }
        for (int i = start; i <= end; i++) {
            if (!isPalindrome(s, start, i)) continue;
            path.add(s.substring(start, i + 1));
            helper(s, i + 1, end);
            path.removeLast();
        }
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        if (right < left) return false;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}