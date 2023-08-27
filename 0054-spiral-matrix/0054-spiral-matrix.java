class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int upperBound = 0, lowerBound = m - 1, leftBound = 0, rightBound = n - 1;
        while (res.size() < m * n) {
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upperBound][i]);
                }
                upperBound++;
            }

            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[lowerBound][i]);
                }
                lowerBound--;
            }
            
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return res;
    }
}