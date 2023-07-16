class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int l = 0, r = potions.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (((long)potions[m] * spells[i]) < (long)success) {
                    l = m + 1;
                } else {
                    res[i] = Math.max(res[i], potions.length - m);
                    if (l == r) break;
                    r = m;
                }
            }
        }
        return res;
    }
}