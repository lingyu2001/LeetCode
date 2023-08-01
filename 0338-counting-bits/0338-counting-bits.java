class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = count(i);
        }
        return dp;
    }
    
    public int count(int i) {
        int cnt = 0;
        while (i != 0) {
            i &= (i - 1);
            cnt++;
        }
        return cnt;
    }
}