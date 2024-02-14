class Solution {
    public int[][] merge(int[][] intervals) {
// 1. sort the intervals based on the start;
// 2. iterate each interval
// 2.1 if the res is empty=> add this interval directly to the res; 
// 2.2 else=> get the last interval, compare the current interval (starti, endi)to the last interval(startk, endk);  if they are non-overlapping, they add this interval to the res; if they are overlapping, then merge them and add the merged one to the res;
// 2.3 return res;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] in : intervals) {
            if (res.size() == 0) {
                res.add(in);
            } else {
                int[] last = res.getLast();
                // non-overlapping
                if (last[1] < in[0]) {
                    res.add(in);
                // overlapping
                } else {
                    res.removeLast();
                    int start = Math.min(last[0], in[0]);
                    int end = Math.max(last[1], in[1]);
                    res.add(new int[]{start, end});
                }
            }
        }
        int[][] res2D = new int[res.size()][2];
        int idx = 0;
        for (int[] in : res) {
            res2D[idx][0] = in[0];
            res2D[idx][1] = in[1];
            idx++;
        }
        return res2D;
    }
}