class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x)
                return mid;
            else if ((long) mid * mid < (long)x) {
                left = mid + 1;
                if (x - mid * mid < x - res * res) {
                    res = mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}