class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //left part is sorted
            else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && mid - 1 >= 0 && target <= nums[mid - 1]) right = mid - 1;
                else left = mid + 1;
                // right part is sorted
            } else {
                if (target <= nums[right] && mid + 1 < nums.length && target >= nums[mid + 1]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}