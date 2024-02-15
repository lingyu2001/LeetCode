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
         Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // If the current balloon's start position is greater than the last end, need another arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}