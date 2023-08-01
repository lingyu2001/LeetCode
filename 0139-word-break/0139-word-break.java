class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            if (wordDict.contains(s.substring(i, i + 1))) {
                dp[i][i] = true;
                // System.out.println("c0:" + s.substring(i,i+1));
            }else dp[i][i] = false;
        }
        
        for (int j = 0; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                for (String w: wordDict) {
                    if (i + w.length() == j + 1 && s.substring(i, i + w.length()).equals(w)) {
                        dp[i][j] = true;
                        break;
                        // System.out.println("c1:" + s.substring(i,j+1));
                    } else if (i + w.length() <= j && s.substring(i, i + w.length()).equals(w)) {
                        dp[i][j] = dp[i + w.length()][j];
                        if (dp[i][j]) break;
                        // System.out.println("c2:" + s.substring(i + w.length(), 1+j)  +" " + dp[i + w.length()][j]);
                    }
                }
            }
        }
        
        return dp[0][len - 1];
    }
}