class Solution {
    int ROW, COL;
    int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    int cnt = -1;
    Queue<int[]> queue = new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        for(int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }
        bfs(grid);
        
        for(int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return cnt == -1 ? 0 : cnt;
    }
    
    public void bfs(int[][] grid) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int[] t = queue.poll();
                for (int[] dir : dirs) {
                    int newi = t[0] + dir[0];
                    int newj = t[1] + dir[1];
                    if (newi >= 0 && newi < ROW && newj >= 0 && newj < COL && grid[newi][newj] == 1) {
                        queue.offer(new int[]{newi, newj});
                        grid[newi][newj] = 2;
                    }
                }
            }
        }
    }
}