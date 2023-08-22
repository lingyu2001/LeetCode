class Solution {
    int ROW, COL;
    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= ROW || j < 0 || j >= COL) return;
        else if (grid[i][j] == '0') return;
        else {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}