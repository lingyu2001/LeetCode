class Solution {
    public int findMin(int[] nums) { 
        int le = 0, ri = nums.length - 1; 
        int res = nums[0];
        while (le <= ri) {
            if (nums[le] <= nums[ri]) {
                res = Math.min(res,nums[le]);
                break;
            }
            int mid = le + (ri - le) / 2;
            if (nums[mid] >= nums[le]) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        return res;
    }
}