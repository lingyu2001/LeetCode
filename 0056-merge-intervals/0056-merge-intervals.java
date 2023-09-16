class Solution {
    LinkedList<int[]> res = new LinkedList<>();
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (start > intervals[i][1]) {
                // [interval] [start]
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if (end < intervals[i][0]) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        if (res.size() == 0) res.add(new int[]{start, end});
        else {
            int[] last = res.getLast();
            if (last[0] != start || last[1] != end) res.add(new int[]{start, end});
        }
        return res.toArray(new int[res.size()][2]);
    }
}