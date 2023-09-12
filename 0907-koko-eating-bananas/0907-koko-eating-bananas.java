class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int p : piles) right = Math.max(p, right);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int p : piles) {
                sum += Math.ceil((double) p / mid);
            }
            if (sum > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}