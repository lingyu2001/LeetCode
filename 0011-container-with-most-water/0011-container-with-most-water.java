class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int len = r - l;
            int width = Math.min(height[r], height[l]);
            max = Math.max(max, len * width);
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}