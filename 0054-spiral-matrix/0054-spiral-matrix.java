class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int upBoundry = 0, downBoundry = row - 1, leftBoundry = 0, rightBoundry = col - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < row * col) {
            // from left to right
            if (upBoundry <= downBoundry) {
                for (int i = leftBoundry; i <= rightBoundry; i++) {
                    res.add(matrix[upBoundry][i]);
                }
                upBoundry++;
            }

            // from top to down
            if (leftBoundry <= rightBoundry) {
                for (int i = upBoundry; i <= downBoundry; i++) {
                    res.add(matrix[i][rightBoundry]);
                }
                rightBoundry--;
            }

            // from right to left;
            if (upBoundry <= downBoundry) {
                for (int i = rightBoundry; i >= leftBoundry; i--) {
                    res.add(matrix[downBoundry][i]);
                }
                downBoundry--;
            }

            if (leftBoundry <= rightBoundry) {
                // from down to top
                for (int i = downBoundry; i >= upBoundry; i--) {
                    res.add(matrix[i][leftBoundry]);
                }
                leftBoundry++;
            }
        }
        return res;
    }
}