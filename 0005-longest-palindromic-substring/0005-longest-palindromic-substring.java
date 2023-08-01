class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                   if (j - i <= 1) { // 情况一 和 情况二
                        dp[i][j] = true;
                   } else if (dp[i+1][j-1]) {
                      dp[i][j] = true;
                   }
                }
            }
        }
        int max = 0;
        String ss = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        ss = s.substring(i, j + 1);
                    }
                }
            }
        }
        if (ss.equals(" ")) ss = s.substring(0,1);
        return ss;
    }
}