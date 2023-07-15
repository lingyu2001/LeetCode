class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (target < nums[left]) return left;
            if (target > nums[right]) return right + 1;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            // 这里不取 mid-1 的原因：
            // 取中点是偏左的，是无法取到右边界处的；
            // 如果 mid-1 处恰好为目标值，将其定为右边界就会导致中点无法取到该位置，
            // 故右边界我们取 mid
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 
        return left;
    }
}