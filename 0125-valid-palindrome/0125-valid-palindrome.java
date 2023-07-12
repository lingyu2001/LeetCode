class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            // make sure pointer i points to the correct character
            while (i < j && !isAlphanumeric(s.charAt(i))) i++;
            // make sure pointer j points to the correct character
            while (i < j && !isAlphanumeric(s.charAt(j))) j--;
            if (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
        // a-z A-Z,0-9
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}