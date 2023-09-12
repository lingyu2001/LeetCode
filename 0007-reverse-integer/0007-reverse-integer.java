class Solution {
    public int reverse(int x) {
        if (x >= 0) return helper(x);
        else return -helper(-x);
    }

    public int helper(int x) {
        int d = 0;
        int res = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < res) return 0;
            res *= 10;
            d = x % 10;
            res += d;
            x /= 10;
        }
        return res;
    }
}