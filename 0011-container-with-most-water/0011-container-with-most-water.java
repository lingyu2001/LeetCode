class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            if (height[right] > height[left]) {
                max = Math.max(w * h, max);
                left++;
            } else {
                max = Math.max(w * h, max);
                right--;
            }
        }
        return max;
    }
}