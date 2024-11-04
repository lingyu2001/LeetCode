class Solution:
    directions = [
        [0,1], [0,-1],[1,0],[-1,0]
    ]
    def exist(self, board: List[List[str]], word: str) -> bool:
        visited = set()
        m = len(board)
        n = len(board[0])
        wrds = list(word)
        for i in range(0,m):
            for j in range(0,n):
                if self.dfs(board, i, j, wrds, 0, m, n, visited):
                    return True
        return False
    def dfs (self, board, i, j, wrds, start,m,n, visited):
        if start == len(wrds):
            return True
        if 0 <= i < m and 0<= j < n and board[i][j] == wrds[start] and (i,j) not in visited:
            visited.add((i,j))
            for x,y in self.directions:
                if self.dfs(board, i+x, j+y, wrds, start + 1, m, n, visited):
                    return True
            visited.remove((i,j))
        return False