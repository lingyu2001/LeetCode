class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i ,j);
                    res++;
                }
            }
        }
        return res;
    }

    int[][] dists = {{1, 0}, {0, 1}, {-1, 0}, {0,-1}};
    public void helper (char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 ||
            j >= grid[0].length || j < 0 ||
            grid[i][j] == '0') 
            return;

        grid[i][j] = '0';
        for (int[] d : dists) {
            int newi = i + d[0];
            int newj = j + d[1];
            helper(grid, newi, newj);
        }
    }
}