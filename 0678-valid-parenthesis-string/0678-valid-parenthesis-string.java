class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (min > 0) min--;
                max--;
            } else {
                if (min > 0) min--;
                max++;
            }
            if (max < 0) return false;
        }
        return min == 0;
    }
}