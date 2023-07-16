class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int m = left + (right - left) / 2;
            if (nums[m] < nums[m + 1]) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return left;
    }
}