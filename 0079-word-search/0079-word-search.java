class Solution {
    int row;
    int col;
    boolean[][] used;
    int[][] dirs = {{1,0}, {0,1},{0, -1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        row = board.length; 
        col = board[0].length;
        used = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (helper(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, String word, int index) {
        if (index >= word.length()) return true;
        if (i < 0 || j < 0 || i >= row || j >= col || used[i][j]) return false;
        if (word.charAt(index) != board[i][j]) return false;
        used[i][j] = true;
        boolean res = false;
        for (int[] d : dirs) {
            int newi = i + d[0];
            int newj = j + d[1];
            res = res || helper(board, newi, newj, word, index + 1);
        }
        used[i][j] = false;
        return res;
    }
}