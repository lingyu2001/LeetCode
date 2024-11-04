class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        
        self.m, self.n = len(matrix), len(matrix[0])
        self.dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        cache = [[0] * self.n for _ in range(self.m)]
        ans = 0
        
        for i in range(self.m):
            for j in range(self.n):
                ans = max(ans, self.dfs(matrix, i, j, cache))
                
        return ans
    
    def dfs(self, matrix: List[List[int]], i: int, j: int, cache: List[List[int]]) -> int:
        if cache[i][j] != 0:
            return cache[i][j]
        
        for dx, dy in self.dirs:
            x, y = i + dx, j + dy
            if 0 <= x < self.m and 0 <= y < self.n and matrix[x][y] > matrix[i][j]:
                cache[i][j] = max(cache[i][j], self.dfs(matrix, x, y, cache))
                
        cache[i][j] += 1
        return cache[i][j]
