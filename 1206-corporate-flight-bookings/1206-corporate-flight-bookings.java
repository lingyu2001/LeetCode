class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] b: bookings) {
            int start = b[0];
            int end = b[1];
            int inc = b[2];
            Update(diff, start - 1, end - 1, inc);
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++){
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public void Update(int[] diff, int start, int end, int inc) {
        diff[start] += inc;
        if (end + 1 < diff.length) diff[end + 1] -= inc;
    }
}