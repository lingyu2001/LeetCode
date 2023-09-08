class Solution {
    int ROW;
    int COL;
    int max,cnt;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        cnt = 0;
        ROW = grid.length;
        COL = grid[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    cnt = 0;
                    dfs(grid, i, j);
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }
    
    public void dfs(int[][] grid, int i, int j) {
        if (i >= ROW || j >= COL||
        i < 0 || j < 0 ||
        grid[i][j] == 0) {
            return ;
        }
        cnt++;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}