class Solution {
    Queue<int[]> queue = new LinkedList<>();
    int row, col;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }
        int dis = 0;
        while (!queue.isEmpty()) {
            // System.out.println(queue.size());
            dis++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                for (int[] dir : dirs) {
                    int newi = i + dir[0];
                    int newj = j + dir[1];
                    if (newi < 0 || newj < 0 || newi >= row || newj >= col || grid[newi][newj] == 2 || grid[newi][newj] == 0) continue;
                    grid[newi][newj] = 2;
                    queue.offer(new int[]{newi, newj});
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return dis == 0 ? 0 : dis - 1;
    }
}