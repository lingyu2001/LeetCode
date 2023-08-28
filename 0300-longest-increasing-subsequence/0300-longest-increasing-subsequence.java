class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int max = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[j - 1] < nums[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}