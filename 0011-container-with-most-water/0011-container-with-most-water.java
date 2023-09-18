class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if(height[left] < height[right]) {
                max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
                left++;
            } else {
                max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
                right--;
            }
        }
        return max;
    }
}