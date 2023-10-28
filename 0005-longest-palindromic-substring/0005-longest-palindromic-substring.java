class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        String res = "";
        // dp(i, j) = if s[i] == s[j] => dp[i][j] = dp[i + 1][j-1]
        // if s[i] != s[j] => dp[i][j] = false;
        // if (dp[i][j]) res.length < j - i + 1: res = s.substring(i, j + 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i > j) continue;
                if (i + 1 >= j) dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1];
                    else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j]) {
                    if (res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}