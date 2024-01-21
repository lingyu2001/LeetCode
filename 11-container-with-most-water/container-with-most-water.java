class Solution {
    public int maxArea(int[] height) {
        // As the pointers move towards each other, every possible width is checked with the tallest possible lines for that width. 
        // This ensures that the maximum area configuration is not missed.
        int lo = 0, hi = height.length - 1;
        int res = 0;
        while (lo < hi) {
            res = Math.max(res, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }
}