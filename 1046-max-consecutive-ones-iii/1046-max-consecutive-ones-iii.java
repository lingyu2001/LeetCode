class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int valid = 0;
        int[] arr = new int[2];
        int res = 0;
        while (right < nums.length) {
            int r = nums[right];
            right++;
            arr[r]++;
            int len = right - left;
            while (arr[0] > k) {
                int l = nums[left];
                arr[l]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}