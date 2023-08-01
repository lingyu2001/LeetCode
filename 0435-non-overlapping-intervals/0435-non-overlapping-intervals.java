class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int s = intervals[0][0];
        int t = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            //no overlapping
            if (intervals[i][0] >= t) {
                s = intervals[i][0];
                t = intervals[i][1];
            } // with overlapping 
            else {
                cnt++;
                if (t > intervals[i][1]) {
                    s = intervals[i][0];
                    t = intervals[i][1];
                }
            }
        }
        return cnt;
    }
}