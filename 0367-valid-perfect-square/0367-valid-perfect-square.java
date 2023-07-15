class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num, res = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == (long)num) {
                return true;
            } else if (square > (long)num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}