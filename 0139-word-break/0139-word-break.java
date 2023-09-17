class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    //  System.out.println(s.substring(i, i + w.length()) + " " + w);
                     dp[i] = dp[i] || dp[i + w.length()];
                }
            }
            // for (boolean m : dp) System.out.print(m + " ");
            // System.out.println("==================");
        }
        return dp[0];
    }
}