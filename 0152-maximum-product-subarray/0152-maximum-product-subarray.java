class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        int min = 1, max = 1;
        for (int n : nums) {
            int t = max * n;
            max = Math.max(n, Math.max(min * n, t));
            min = Math.min(n, Math.min(min * n, t));
            res = Math.max(max, res);
        }
        return res;
    }
}