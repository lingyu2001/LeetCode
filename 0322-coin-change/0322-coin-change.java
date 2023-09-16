class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i >= c) {
                    if (dp[i - c] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
            // for (int k : dp)
            //     System.out.print(k + " ");
            // System.out.println();
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}