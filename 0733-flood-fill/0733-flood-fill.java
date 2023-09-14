class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int row, col;
    int c;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        row = image.length;
        col = image[0].length;
        c = image[sr][sc];
        if (c == color) return image;
        dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= row || j >= col || image[i][j] != c) return ;
        // System.out.println(i + "," + j + ":" + image[i][j]);
        image[i][j] = color;
        for (int[] dir : dirs) {
            dfs(image, i + dir[0], j + dir[1], color);
        }
    }
}