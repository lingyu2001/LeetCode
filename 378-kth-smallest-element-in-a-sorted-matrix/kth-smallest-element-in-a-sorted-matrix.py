class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        start = matrix[0][0]
        end = matrix[n - 1][n - 1]
        while start < end:
            mid = start + (end - start) // 2
            smaller, larger = (matrix[0][0], matrix[n - 1][n - 1])
            cnt, smaller, larger = self.countSmaller(matrix, mid, smaller, larger)
            if cnt == k:
                return smaller
            elif cnt < k:
                start = larger
            else:
                end = smaller
        return start
    def countSmaller(self,matrix, mid, smaller, larger):
        n = len(matrix)
        row = n - 1
        col = 0
        cnt = 0
        while row >= 0 and col < n:
            if matrix[row][col] <= mid:
                smaller = max(smaller, matrix[row][col])
                col += 1
                # correct: cnt += 1
                cnt += (row + 1)
            else:
                larger = min(larger, matrix[row][col])
                row -= 1
                
        return cnt, smaller, larger