class Solution {
    int row, col;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    int cnt = 0;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0|| i >= row || j >= col || grid[i][j] == '0') return ;
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}