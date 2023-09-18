class Solution {
    public int myAtoi(String s) {
        long sum = 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        int sym = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                sym = -1;
                continue;
            } else if (i == 0 && s.charAt(i) == '+') {
                sym = 1;
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                return (int)sum * sym;
            }
            sum = sum * 10 + s.charAt(i) - '0';
            // System.out.println(Integer.MIN_VALUE);
            if (sum * sym > Integer.MAX_VALUE) return Integer.MAX_VALUE * sym;
            else if (sum * sym < Integer.MIN_VALUE) return Integer.MIN_VALUE * sym;
        }
        return (int)sum * sym;
    }
}