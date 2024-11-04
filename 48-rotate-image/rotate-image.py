# 注意：python 代码由 chatGPT\U0001f916 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def rotate(self, matrix):
        n = len(matrix)
        # 先沿对角线反转二维矩阵
        for i in range(n):
            for j in range(i, n):
                # swap(matrix[i][j], matrix[j][i])
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # 然后反转二维矩阵的每一行
        for row in matrix:
            self.reverse(row)

    # 反转一维数组
    def reverse(self, arr):
        i, j = 0, len(arr) - 1
        while j > i:
            # swap(arr[i], arr[j])
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
# 详细解析参见：
# https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/
