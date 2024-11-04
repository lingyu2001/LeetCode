class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] > nums[nums.length - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return res;
    }
}