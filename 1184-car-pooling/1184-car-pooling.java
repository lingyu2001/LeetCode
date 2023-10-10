class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 1001;
        int[] diff = new int[n];
        for (int[] t : trips) {
            int num = t[0];
            int start = t[1];
            int end = t[2] - 1;
            update(diff, start, end, num, n);
        }
        int[] capa = new int[n];
        capa[0] = diff[0];
        for (int i = 1; i < n; i++) {
            capa[i] = capa[i - 1] + diff[i];
        }
        for (int i = 0; i < n; i++)
            if (capa[i] > capacity) return false;
        return true;
    }

    public void update(int[] diff, int start, int end, int inc, int n) {
        diff[start] += inc;
        if (end + 1 < n) diff[end + 1] -= inc;
    }
}