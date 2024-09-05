class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int k = 0; k < s.length(); k++) {
            String str1 = palindrome(s, k, k);
            String str2 = palindrome(s, k, k + 1);
            if (str1.length() < str2.length()) {
                str1 = str2;
            }
            if (res.length() < str1.length()) {
                res = str1;
            }
        }
        return res;
    }

    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}