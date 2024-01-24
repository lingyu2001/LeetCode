class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int upperBound = 0;
        int lowerBound = m - 1;
        int leftBound = 0;
        int rightBound = n - 1;
        while (list.size() < m * n) {
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    list.add(matrix[upperBound][i]);
                }
                upperBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    list.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    list.add(matrix[lowerBound][i]);
                }
                lowerBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    list.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return list;
    }
}