class Solution(object):
    def isToeplitzMatrix(self, matrix):
        # Get the number of rows and columns in the matrix
        num_rows = len(matrix)
        num_cols = len(matrix[0])

        # Iterate over the matrix starting from the second row and second column
        for row in range(1, num_rows):
            for col in range(1, num_cols):
                # Compare the current element with the element diagonally above and to the left
                if matrix[row][col] != matrix[row - 1][col - 1]:
                    # If they are not equal, the matrix is not a Toeplitz matrix
                    return False
        # If all diagonally adjacent elements are equal, it's a Toeplitz matrix
        return True
