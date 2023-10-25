class Solution {
    public int search(int[] nums, int target) {
        int rotateIndex = findRotateIndex(nums);
        // compare the target to the rotatepoint
        // nums[index] <= tgt <= tgt[nums.length - 1] => do binary search on the right part
        // nums[0] <= tgt <= nums[index - 1] => do binary search on the left part
        // else. return -1
        int left = 0, right = nums.length - 1;
        if (nums[rotateIndex] <= target && target <= nums[nums.length - 1]) {
            return binarySearch(nums, rotateIndex, nums.length - 1, target);
        } else if (rotateIndex >= 1 && nums[0] <= target && target <= nums[rotateIndex - 1]) {
            return binarySearch(nums, 0, rotateIndex - 1, target);
        } else {
            return -1;
        }
    }

    public int findRotateIndex (int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) return left;
            else {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return left;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}