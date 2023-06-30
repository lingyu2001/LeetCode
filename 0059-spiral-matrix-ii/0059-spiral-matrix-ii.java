class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startx = 0, starty = 0;
        int loop = n / 2;
        int mid = n / 2;
        int count = 1;
        int offset = 1;
        while (loop != 0) {
            int i = startx;
            int j = starty;
            //left->right
            for (j = starty; j < n - offset; j++) {
                res[startx][j] = count++;
            }
            //up->down
            for (i = startx; i < n - offset; i++) {
                res[i][j] = count++;
            }
            //right->left
            for (; j > starty; j--) {
                res[i][j] = count++;
            }
            //down->up
            for (; i > startx; i--) {
                res[i][j] = count++;
            }
            offset++;
            startx++;
            starty++;
            loop--;
        }
        if (n % 2 != 0) {
            res[mid][mid] = count;
        }
        return res;
    }
}