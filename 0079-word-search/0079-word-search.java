class Solution {
    boolean[][] used ;
    int ROW, COL;
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        used = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(helper(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] b, String w, int i, int j, int cIndex) {
        if (cIndex == w.length()) return true;
        if (i < 0 || 
            i >= ROW || 
            j < 0 || 
            j >= COL||
            b[i][j] != w.charAt(cIndex) ||
            used[i][j]) {
            return false;
        }
        used[i][j] = true;
        boolean res = (helper(b,w, i + 1,j,cIndex + 1) ||
                      helper(b,w, i,j + 1,cIndex + 1) ||
                      helper(b,w, i - 1,j,cIndex + 1) ||
                      helper(b,w, i,j - 1,cIndex + 1));
        used[i][j] = false;
        return res;
    } 
}