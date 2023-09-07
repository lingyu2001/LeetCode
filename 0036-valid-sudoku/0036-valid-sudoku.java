class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = null;
        Set<Character> col = null;
        for (int i = 0; i < 9; i++) {
            row = new HashSet<>();
            col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') if (!row.add(board[i][j])) return false;
                if (board[j][i] != '.') if (!col.add(board[j][i])) return false;
            }
        }
        // block
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!check(i,j,board)) return false;
            }
        }
        return true;
    }
    
    public boolean check(int i, int j, char[][] board) {
        int rows = i + 3;
        int cols = j + 3;
        Set<Character> block = new HashSet<>();
        for (int m = i; m < rows; m++) {
            for (int n = j; n < cols; n++) {
                if (board[m][n] != '.') {
                    if (!block.add(board[m][n])) return false;
                }
            }
        }
        return true;
    }
}