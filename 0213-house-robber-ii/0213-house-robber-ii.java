class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0],nums[1]);
        int[] nums1 = new int[nums.length - 1];
        System.arraycopy(nums,0,nums1,0, nums1.length);
        int[] nums2 = new int[nums.length - 1];
        System.arraycopy(nums,1,nums2,0, nums2.length);
        return Math.max(rob1(nums1), rob1(nums2));
    }
    public int rob1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0],nums[1]);
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }
        return dp[n - 1];
    }
}