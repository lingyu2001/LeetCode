class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int upperBound = 0, lowerBound = m - 1;
        int leftBound = 0, rightBound = n - 1;
        while (list.size() < m * n) {
            if (upperBound <= lowerBound) {
                // from left to right
                for (int j = leftBound; j <= rightBound; j++) {
                    list.add(matrix[upperBound][j]);
                }
                upperBound++;
            }
            
            if (leftBound <= rightBound) {
                // from top to bottom
                for (int i = upperBound; i <= lowerBound;i++) {
                    list.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            
            if (upperBound <= lowerBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    list.add(matrix[lowerBound][j]);
                }
                lowerBound--;
            }
            
            if(leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    list.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return list;
    }
}