class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            matrix[i] = matrix[i][::-1]
        map = defaultdict(list)
        for i in range(m):
            for j in range(n):
                map[i+j].append(matrix[i][j])
        for v in map.values():
            if len(set(v)) > 1:
                return False
        return True
