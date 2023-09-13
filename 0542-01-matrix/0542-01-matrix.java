class Solution {
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};
    int row, col;
    int[][] res;
    public int[][] updateMatrix(int[][] mat) {
        row = mat.length;
        col = mat[0].length;
        res = new int[row][col];
        for (int[] arr : res) {
            Arrays.fill(arr, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }

        int dis = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0];
            int j = p[1];
            for (int[] dir : dirs) {
                int newi = i + dir[0];
                int newj = j + dir[1];
                if (newi < 0 || newj < 0 || newi >= row || newj >= col || res[newi][newj] != -1) continue; {
                    queue.offer(new int[]{newi, newj});
                    res[newi][newj] = res[i][j] + 1;
                }
            }
        }
        return res;
    }
}