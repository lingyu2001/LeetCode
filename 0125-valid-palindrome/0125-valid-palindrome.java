class Solution {
    public boolean isPalindrome(String s) {
        // 1. trim
        s = s.trim();
        // 2. convert to lowercase
        s = s.toLowerCase();
        // 3. two pointers, one for the front, one for the back
        //    while left <= right
        //    when moving pointers, if it is non-alphanumeric, then skip it, else the pointer stops
        //    when both pointers stop, compare the two characters, if they are the same, => continue; else return false;
        // 4. end while => return true;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !isAlphaNumeric(s, left)) {
                left++;
            }
            while (left <= right && !isAlphaNumeric(s, right)) {
                right--;
            }
            // System.out.println(s.substring(left, left + 1) + ' ' + s.substring(right, right + 1));
            if (left <= right && s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphaNumeric(String s, int p) {
        return (s.charAt(p) >= 'a' && s.charAt(p) <= 'z') || (s.charAt(p) >= '0' && s.charAt(p) <= '9');
    }
}