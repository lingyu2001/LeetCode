class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = 0;
        // find the row index
        int up = 0, down = matrix.length;
        while (up < down) {
            i = up + (down - up) / 2;
            if (matrix[i][0] == target) return true;
            if (i - 1 >= 0 && matrix[i][0] > target && matrix[i - 1][0] < target){
                i = i - 1;
                break;
            }else if (i + 1 < matrix.length && matrix[i][0] < target && matrix[i + 1][0] > target){
                break;
            }else if (matrix[i][0] > target) down = i;
            else up = i + 1;
        }
        int left = 0, right = matrix[i].length;
        while (left < right) {
            j = left + (right - left) / 2;
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) left = j + 1;
            else right = j;
        }
        return false;
    }
}