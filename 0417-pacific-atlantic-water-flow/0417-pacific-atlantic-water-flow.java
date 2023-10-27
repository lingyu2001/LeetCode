class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int row, col;
    int[][] h;
    boolean[][] pacific = new boolean[row][col];
    boolean[][] atlantic = new boolean[row][col];
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        h = heights;
        row = h.length;
        if (row == 0) return res; 
        col = h[0].length;
        pacific = new boolean[row][col];
        atlantic = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            helper(0, i, pacific, Integer.MIN_VALUE);
            helper(row - 1, i, atlantic, Integer.MIN_VALUE);
        }
        for (int j = 0; j < row; j++) {
            helper(j, 0, pacific, Integer.MIN_VALUE);
            helper(j, col - 1, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(new ArrayList<>(list));
                }
            }
        }
        return res;
    }

    public void helper(int i, int j, boolean[][] ocean, int val) {
        if (i < 0 || j < 0 || i >= row || j >= col || val > h[i][j] || ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        for (int[] d : dirs) {
            int newi = i + d[0];
            int newj = j + d[1];
            helper(newi, newj, ocean, h[i][j]);
        }
    }
}