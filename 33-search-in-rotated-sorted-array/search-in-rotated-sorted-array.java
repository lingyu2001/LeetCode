class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[lo] <= nums[mid]) {
                //left part is sorted
                if (nums[lo] <= target && target <= nums[mid]) {
                    hi = mid - 1;
                } else lo = mid + 1;
            } else {
                // right part is sorted
                if (mid + 1 < nums.length && nums[mid + 1] <= target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}