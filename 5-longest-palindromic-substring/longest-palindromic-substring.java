class Solution {
    public String longestPalindrome(String s) {
        /*
        dp(i,j) = 
        if i == j, return true;
        if i + 1 == j, return s.charAt(i) == s.charAt(j)
        else return s.charAt(i) == s.charAt(j) && dp(i + 1, j - 1);
        */
        // i down, j up
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        String res = "";
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = true;
                else if (i + 1 == j) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j]) {
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}