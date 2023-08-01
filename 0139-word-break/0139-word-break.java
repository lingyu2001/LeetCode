class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (String w: wordDict) {
                if (
                    (i + w.length() <= len) &&
                    (s.substring(i, i + w.length()).startsWith(w))
                )
                    dp[i] = dp[i + w.length()];
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
}