class Solution {
    public boolean canPartition(int[] nums) {
        //sum / 2
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - nums[i] < 0) {
                    if (i == 0) dp[i][j] = false;
                    else dp[i][j] = dp[i - 1][j];
                } else {
                    if (i == 0) dp[i][j] = false;
                    else dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }
}