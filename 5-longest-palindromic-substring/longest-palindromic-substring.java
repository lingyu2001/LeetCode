class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = helper (s, i, i);
            String s2 = helper (s, i, i + 1);
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    public String helper (String s, int le, int ri) {
        while (le >= 0 && ri < s.length() && s.charAt(le) == s.charAt(ri)) {
            le--;
            ri++;
        }
        return s.substring(le + 1, ri);
    }
}