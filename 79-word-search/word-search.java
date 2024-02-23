class Solution {
    boolean[][] used;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int i, int j, int idx) {
        if (i < 0 || j < 0|| i >= m || j >= n || used[i][j] || board[i][j] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;
        boolean flag = false;
        used[i][j] = true;
        
            flag = helper(board, word, i + 1, j, idx + 1) ||
                    helper(board, word, i, j + 1, idx + 1) || 
                    helper(board, word, i - 1, j, idx + 1) ||
                    helper(board, word, i, j - 1, idx + 1);
        
        used[i][j] = false;
        return flag;
    }
}