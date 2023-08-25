class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> l = new ArrayList<>();
        int s = intervals[0][0];
        int t = intervals[0][1];
        int i = 1;
        for (; i < intervals.length; i++) {
            if (intervals[i][0] > t) {
                l.add(new int[]{s, t});
                s = intervals[i][0];
                t = intervals[i][1];
            } else if (intervals[i][1] < s) {
                l.add(new int[]{intervals[i][0],intervals[i][1]});
            } else {
                s = Math.min(s, intervals[i][0]);
                t = Math.max(t, intervals[i][1]);
            }
        }
        l.add(new int[]{s, t});
        return l.toArray(new int[l.size()][]);
    }
}