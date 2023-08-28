class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max = 1;
        String res = s.substring(0,1);
        for (int i = 0; i < s.length();i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (j - i == 1) dp[i][j] = 2;
                    else if (dp[i+1][j-1] != 0)
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (j - i + 1 > max && dp[i][j] != 0) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}