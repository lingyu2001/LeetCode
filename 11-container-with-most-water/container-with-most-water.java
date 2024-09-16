class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int max = 0;
        while (l < r) {
            int curr = (r - l) * Math.min(height[l], height[r]);
            if (curr > max) {
                max = curr;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}