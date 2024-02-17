class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // method 1. BF: O(m*n)
        // method 2. first do binary search on the column lines, logm
        //             second, do binary search on the row lines logn
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;
        int row = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((matrix[mid][0] <= target && mid + 1 < m && target < matrix[mid + 1][0]) || mid + 1 >= m) {
                row = mid;
                break;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target){
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}