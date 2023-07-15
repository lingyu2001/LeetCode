class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n, max = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long cnt = (long)((1 + mid) * (mid / 2.0));
            if (cnt > (long)n) {
                right = mid - 1;
            } else {
                max = Math.max(max, mid);
                left = mid + 1;
            }
        }
        return max;
    }
}