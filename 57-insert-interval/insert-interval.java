class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        // flag : to determine whether i need to check or just add the rest of the 
        // intervals to the list
        boolean flag = false;
        for (int[] in : intervals) {
            int starti = in[0];
            int endi = in[1];
            if (flag) {
                res.add(in);
                continue;
            }
            // situation 1: non overlapping 1
            if (newInterval[1] < starti) {
                res.add(newInterval);
                res.add(in);
                flag = true;
            } else if (endi < newInterval[0]) {
                // situation 2
                res.add(in);
            } else {
                // overlapping
                newInterval[0] = Math.min(in[0], newInterval[0]);
                newInterval[1] = Math.max(in[1], newInterval[1]);
            }
        }
        if (!flag) res.add(newInterval);
        // return the result
        int[][] ret = new int[res.size()][2];
        int idx = 0;
        for (int[] in : res){
            ret[idx][0] = in[0];
            ret[idx++][1] = in[1];
        }
        return ret;
    }
}