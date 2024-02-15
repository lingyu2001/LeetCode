class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int end = points[0][1];
        int res = 1;
        for (int[] p : points) {
            if (end < p[0]) {
                res++;
                end = p[1];
            }
        }
        return res;
    }
}