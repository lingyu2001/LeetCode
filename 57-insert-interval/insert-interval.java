class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};
        int[][] newIns = new int[intervals.length + 1][2];
        int i = 0;
        for (i = 0; i < newIns.length - 1; i++) {
            if (intervals[i][0] < newInterval[0]) {
                newIns[i] = intervals[i];
            } else {
                break;
            }
        }
        newIns[i++] = newInterval;
        for (int idx = i - 1; idx < intervals.length; idx++) {
            newIns[i++] = intervals[idx];
        }
        return merge(newIns);
    }

    public int[][] merge(int[][] intervals) {
        // Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1 ; i < intervals.length; i++) {
            int start = list.getLast()[0];
            int end = list.getLast()[1];
            if (end < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                // list.getLast()[0] = Math.min(start, intervals[i][0]);
                list.getLast()[1] = Math.max(end, intervals[i][1]);
            }
        }
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for (int[] in : list) {
            res[idx][0] = in[0];
            res[idx][1] = in[1];
            idx++;
        }
        return res;
    }
}