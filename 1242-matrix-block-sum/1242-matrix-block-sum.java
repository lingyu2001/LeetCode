class Solution {
    int[][] preSum;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + mat[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = Math.max(0, i - k);
                int x2 = Math.min(m - 1, i + k);
                int y1 = Math.max(0, j - k);
                int y2 = Math.min(n - 1, j + k);
                res[i][j] = helper(x1, y1, x2, y2);
            }
        }
        return res;
    }

    public int helper(int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
    }
}