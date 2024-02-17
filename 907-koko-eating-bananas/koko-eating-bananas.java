class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 1000000000;
        int l = 1, r = k;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int speed = l + (r - l) / 2;
            int time = 0;
            for (int i : piles) {
                time += Math.ceil(i * 1.0 / speed);
            }
            if (time <= h) {
                res = Math.min(res, speed);
                r = speed - 1;
            } else if (time > h) {
                l = speed + 1;
            }
        }
        return res;
    }
}