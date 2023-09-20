class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlphaNum(s.charAt(left))) left++;
            while (left < right && !isAlphaNum(s.charAt(right))) right--;
            System.out.println(left + ":" + s.charAt(left) + " " + right + ":" + s.charAt(right));
            if (left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphaNum(char c) {
        if (
            (c >= '0' && c <='9') ||
           (c >= 'a' && c <= 'z'))
        return true;
        else return false;
    }
}