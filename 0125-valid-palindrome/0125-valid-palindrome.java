class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        // System.out.println(s);
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < s.length() && !isAlphanum(s.charAt(left))) left++;
            // System.out.print(left + " ");
            while (right>= 0 && !isAlphanum(s.charAt(right))) right--;
             // System.out.print(right + " ");
            // System.out.println();
            if (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (left >= right) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean isAlphanum(char c) {
        return (c>='a' && c<='z') || (c>='0' && c<= '9');
    }
}