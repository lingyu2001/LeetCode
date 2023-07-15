class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int k = 1;
        while (k < max) {
            int mid = (k + max) / 2;
            int curHour = 0;
            for (int i = 0; i < piles.length; i++) {
                curHour += (int) Math.ceil(piles[i] * 1.0 / mid);
            }
            if (curHour > h) {
                k = mid + 1;
            } else {
                max = mid;
            }
        }
        return k;
    }
}