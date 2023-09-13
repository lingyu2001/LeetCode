class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res= new ArrayList<>();
        if (intervals.length == 0) return new int[][]{newInterval};
        int start = newInterval[0], end = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (start > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
            }
        }
        if (res.size() != 0 && res.get(res.size() - 1)[0] == start &&  res.get(res.size() - 1)[1] == end) ;
        else res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}