class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            System.arraycopy(dp, 0, temp, 0, n);
            for (int j = 0; j < flights.length; j++) {
                if (dp[flights[j][0]] != Integer.MAX_VALUE) {
                    if (dp[flights[j][0]] + flights[j][2] < temp[flights[j][1]]) {
                        temp[flights[j][1]] = dp[flights[j][0]] + flights[j][2];
                    }
                }
            }
            dp = temp;
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}