class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long total = (long)((mid / 2.0) * (mid + 1));
            if (total == n) {
                return mid;
            } else if (total < n) {
                res = Math.max(res,mid);
                left = mid + 1;
            } else {
                // 这里为什么是mid - 1；
                // 这个不是查找某一个数，
                right = mid - 1;
            }
        }
        return res;
    }
}