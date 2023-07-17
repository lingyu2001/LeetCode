class Solution {
    public boolean validPalindrome(String s) {
        // bf
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return helper(chars, i + 1, j) || helper(chars, i, j - 1);
            }
        }
        return true;
    }
    
    public boolean helper(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}