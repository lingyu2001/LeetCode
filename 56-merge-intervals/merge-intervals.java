class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1 ; i < intervals.length; i++) {
            int start = list.getLast()[0];
            int end = list.getLast()[1];
            if (end < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                list.getLast()[0] = Math.min(start, intervals[i][0]);
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