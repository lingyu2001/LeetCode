class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int res = 0;
        int starti = intervals[0][0];
        int endi = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // if they are non-overlapping
            if (endi <= intervals[i][0]) {
                starti = intervals[i][0];
                endi = intervals[i][1];
            } else {
                res++;
            }
        }
        return res;
    }
}