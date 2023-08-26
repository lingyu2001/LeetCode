class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int cnt = 0;
        int end = intervals[0][1], start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            //not overlapping
            if (end <= intervals[i][0]) {
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                cnt++;
                if (end > intervals[i][1]) {
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }
        return cnt;
    }
}