class Solution {
    int row, col;
    boolean res = false;
    boolean[][] visited;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1 ,0}};
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                helper(board, word, i, j, 0);
                if (res) return true;
            }
        }
        return false;
    }

    public void helper(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) {
            res = true; 
            return;
        }
        if (i < 0 || j < 0 || i >= row || j >= col || word.charAt(k) != board[i][j] || visited[i][j]) return ;
        visited[i][j] = true;
        for (int[] d : dir) {
            helper(board, word, i + d[0], j + d[1], k + 1);
        }
        visited[i][j] = false;
    }
}