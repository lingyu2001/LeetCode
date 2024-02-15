class Solution {
    public int findMinArrowShots(int[][] points) {
        int res = 1;
        // 1. sort the array based on the first element =>nlogn
        // 2. initial starti, endi = first interval in the points
        // 3. iterate the points array, (from index 1) =>n
        //     3.1 if the two intervals are overlapping, but not like overlapping at the edge, then merge the starti, endi and the interval
        //     3.2 if they overlapping at the edge, then continue;
        //     3.3 if they are non-overlapping, then res++; and update the starti, endi with the new interval
        // 4. return res;
        // time complexity: nlogn
        // step 1:
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        // step 2
        int starti = points[0][0];
        int endi = points[0][1];
        // step 3
        for (int i = 1; i < points.length; i++) {
            // 3.1 
            if (points[i][0] < endi) {
                starti = Math.max(points[i][0], starti);
                endi = Math.min(points[i][1], endi);
                // 3.2
            } else if (points[i][0] == endi) {
                continue;
            } else {
                res++;
                starti = points[i][0];
                endi = points[i][1];
            }
        }
        return res;
    }
}