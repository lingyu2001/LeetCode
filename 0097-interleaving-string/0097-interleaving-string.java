class Solution {
    int[][] memo;
    int m, n;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        if (m + n != s3.length()) return false;
        memo = new int[m + 1][n + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return helper(s1, 0, s2, 0, s3);
    }

    public boolean helper(String s1, int i, String s2, int j, String s3) {
        if (i + j == s3.length()) {
            return true;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1 ? true : false;
        }

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res =  helper(s1, i + 1,s2, j,s3);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res = res || helper(s1, i, s2, j + 1, s3);
        }
        memo[i][j] = res ? 1 : 0;
        return res;
    }
}