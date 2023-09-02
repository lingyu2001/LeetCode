class Solution {
    public int[] plusOne(int[] digits) {
        int digit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = (digits[i] + digit) / 10;
            digits[i] = (digits[i] + digit) % 10;
            digit = tmp;
        }
        if (digit != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = digit;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }
}