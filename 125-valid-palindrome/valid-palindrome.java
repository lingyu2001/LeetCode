class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l <= r && !isAphanumeric(s, l)) {
                l++;
            }
            while (l <= r && !isAphanumeric(s, r)) {
                r--;
            }
            if (l <= r && s.charAt(l) != s.charAt(r)) {
                return false;
            } 
            l++;
            r--;
        }
        return true;
    }
    boolean isAphanumeric (String s, int p) {
        return (s.charAt(p) >= 'a' && s.charAt(p) <= 'z') || (s.charAt(p) >= '0' && s.charAt(p) <= '9');
    }
}