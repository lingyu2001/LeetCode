class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int digit = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >=0 || p2 >=0 || digit > 0) {
            int n1 = 0, n2 = 0;
            if (p1 >= 0) {
                n1 = num1.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                n2 = num2.charAt(p2) - '0';
                p2--;
            }
            int num = (n1 + n2 + digit) % 10;
            digit = (n1 + n2 + digit) / 10;
            sb.append(num);
        }
        return sb.reverse().toString();
    }
}