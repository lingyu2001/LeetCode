class Solution {
    public int singleNonDuplicate(int[] nums) {
         int left = 0, right = nums.length - 1;
         while (left < right) {
            int mid = left + (right - left) / 2;
            int rightSize = right - mid;
            if (rightSize % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else if (nums[mid] == nums[mid - 1]){
                    right = mid - 2;
                } else {
                    return nums[mid];
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    right = mid - 1;
                } else if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[left];
    }
}