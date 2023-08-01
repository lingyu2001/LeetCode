class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        int startInsert = newInterval[0];
        int endInsert = newInterval[1];
        int i = 0;
        for (; i < intervals.length; i++) {
            int starti = intervals[i][0];
            int endi = intervals[i][1];
            if (endi < startInsert) l.add(new int[]{intervals[i][0],intervals[i][1]});
            else if (endInsert < starti) {
                break;
            } else {
                //overlapping 
                startInsert = Math.min(startInsert, starti);
                endInsert = Math.max(endInsert, endi);
            }
        }
        l.add(new int[]{startInsert, endInsert});
        
        // System.out.println(i);
        // after break;
        for (; i < intervals.length; i++) {
            // System.out.println(intervals[i][0] + " " + intervals[i][1]);
            l.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        
        if (l.size() == 0) l.add(new int[]{newInterval[0],newInterval[1]});
        // System.out.println(l.size());
        int[][] res = new int[l.size()][2];
        int j = 0;
        for (int[] k : l) {
            // System.out.println(k[0] + " " + k[1]);
            res[j][0] = k[0];
            res[j][1] = k[1];
            j++;
        }
        return res;
    }
}