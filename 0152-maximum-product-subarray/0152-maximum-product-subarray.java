class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = 1, min = 1, res = 0;
        for (int n : nums) {
            int t = n * max;
            max = Math.max(n, Math.max(t, min * n));
            min = Math.min(n, Math.min(t, min * n));
            res = Math.max(res, max);
        }
        return res;
    }
}