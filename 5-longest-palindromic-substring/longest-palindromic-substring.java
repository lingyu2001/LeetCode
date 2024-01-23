class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = helper (s, i, i);
            String s2 = helper(s, i, i + 1);
            res = res.length() > s1.length()? res : s1;
            res = res.length() > s2.length()? res : s2;
        }
        return res;
    }

    public String helper(String s, int i, int j) {
        int lo = i, hi = j;
        while (lo >=0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        return s.substring(lo + 1, hi);
    }
}