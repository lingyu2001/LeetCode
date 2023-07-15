class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n, max = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long cnt = ((1 + mid) * mid)/ 2;
            if (cnt == n) return (int)mid;
            else if (cnt < n) {
                left = (int)mid + 1;
                max = Math.max(max, (int)mid);
            }else right = (int)mid - 1;
        }
        return max;
    }
}