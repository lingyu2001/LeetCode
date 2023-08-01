class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int index = 1;
        for (int i = 1; i < dp.length; i++) {
            if (i == index) {
                index *= 2;
                dp[i] = 1 + dp[0];
            } else if (i < index) {
                dp[i] = 1 + dp[i - index / 2];
            }
        }
        return dp;
    }
}