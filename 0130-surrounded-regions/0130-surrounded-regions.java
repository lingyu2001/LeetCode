class Solution {
    int ROW, COL;
    int[][] dirs = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public void solve(char[][] board) {
        ROW = board.length;
        COL = board[0].length;
        for (int i = 0; i < ROW; i++) {
            dfs(board,i,0);
            dfs(board,i, COL - 1);
        }
        for (int j = 0; j < COL; j++){
            dfs(board, 0, j);
            dfs(board, ROW - 1, j);
        }
        
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= ROW || j >= COL || board[i][j] == 'X' || board[i][j] == '1') return;
        board[i][j] = '1';
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}