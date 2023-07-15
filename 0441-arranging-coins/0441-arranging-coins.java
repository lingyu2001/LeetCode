class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n, max = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long cnt = (long)((1 + mid) * (mid / 2.0));
            if (cnt == n) return mid;
            else if (cnt < n) {
                left = mid + 1;
                max = Math.max(max, mid);
            }else right = mid - 1;
        }
        return max;
    }
}