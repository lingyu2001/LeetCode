class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i <= j && !isAlphanumeric(s, i)) i++;
            while (i <= j && !isAlphanumeric(s, j)) j--;
            if (i <= j) {
                if(s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }
                else return false;
            } 
        }
        return true;
    }

    public boolean isAlphanumeric(String s, int p) {
        return (s.charAt(p) >= 'a' && s.charAt(p) <= 'z') || (s.charAt(p) >= '0' && s.charAt(p) <= '9');
    }
}