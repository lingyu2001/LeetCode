class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int minVal = Integer.MAX_VALUE;
        int minIndex = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < minVal) {
                minVal = nums[mid];
                minIndex = mid;
            }
            if (nums[mid] <= nums[nums.length - 1]) {
                // on the right part
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (nums[minIndex] > target) return -1;
        if (nums[nums.length - 1] >= target) {
            l = minIndex;
            r = nums.length - 1;
        } else {
            l = 0;
            r = minIndex - 1;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}