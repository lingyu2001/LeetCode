class Solution(object):
    def countUnguarded(self, m, n, guards, walls):
        """
        :type m: int
        :type n: int
        :type guards: List[List[int]]
        :type walls: List[List[int]]
        :rtype: int
        """
        # grid = [[0] * n] * m creates a grid where each row is a reference to the same list. 
        # Modifying one row will modify all rows.
        grid = [[0] * n for _ in range(m)]
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        for i,j in guards:
            grid[i][j] = 1

        for i,j in walls:
            grid[i][j] = 2
 
        # for i, j in guards:
        #     for dx, dy in directions:
        #         x, y = i + dx, j + dy
        #         while 0 <= x < m and 0 <= y < n and grid[x][y] != 1 and grid[x][y] != 2:
        #             if grid[x][y] == 0:  # Only mark unvisited cells
        #                 grid[x][y] = 3  # Guarded
        #             x += dx
        #             y += dy
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    for dx, dy in directions:
                        self.dfs(grid, m, n, i ,j, dx, dy)
        for k in grid:
            print(k)
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    res += 1
        return res
    
    def dfs(self, grid, m, n, i, j, dx, dy):
        newi = i + dx
        newj = j + dy
        if 0 <= newi < m and 0 <= newj < n:
            if grid[newi][newj] == 0 or grid[newi][newj] == 3:
                grid[newi][newj] = 3
                self.dfs(grid, m, n, newi, newj, dx, dy) 