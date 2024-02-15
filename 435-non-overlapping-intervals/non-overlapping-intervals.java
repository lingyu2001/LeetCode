class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int end = intervals[0][1];
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] in = intervals[i];
            if (end <= in[0]) {
                // non-overlapping
                res++;
                end = in[1];
            }
        }
        return intervals.length - res;
    }
}