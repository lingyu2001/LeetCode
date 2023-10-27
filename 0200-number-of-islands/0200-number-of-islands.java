class Solution {
    int row;
    int col;
    char[][] g;
    int res = 0;
    int[][] dirs = {{0,1}, {0, -1}, {1, 0} ,{-1, 0}};
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        g = grid;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (g[i][j] == '1') {
                    res++;
                    helper(i, j);
                }
            }
        }
        return res;
    }

    public void helper(int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || g[i][j] == '0') return ;
        g[i][j] = '0';
        for (int[] d: dirs) {
            int newi = i + d[0];
            int newj = j + d[1];
            helper(newi ,newj);
        }
    }
}