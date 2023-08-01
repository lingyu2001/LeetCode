class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        int max = 1;
        for (int i = 1; i < len + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] =  Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        for (int i : dp) {
            System.out.print(i + " ");
        }
        return max;
    }
}