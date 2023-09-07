class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) low--;
                high--;
            } else {
                if (low > 0) low--;
                high++;
            }
            if (high < 0) return false;
            i++;
        }
        return low == 0;
    }
}