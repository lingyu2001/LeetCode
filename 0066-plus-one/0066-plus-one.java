class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] + 1 == 10) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
            if (i == 0 && digits[i] == 0) flag = true;
        }
        
        if (flag) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits,0, res,1, digits.length);
            return res;
        }
        return digits;
    }
}