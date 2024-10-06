class Solution:
    directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        if m == 0:
            return -1
        queue = deque()
        fresh = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1
        level = 0
        while len(queue) != 0 and fresh > 0:
            size = len(queue)
            level += 1
            for _ in range(size):
                a, b = queue.popleft()
                for d in self.directions:
                    i = a + d[0]
                    j = b + d[1]
                    if 0 <= i < m and 0 <= j < n and grid[i][j] == 1:
                        queue.append((i, j))
                        grid[i][j] = 2
                        fresh -= 1
        return level if fresh == 0 else -1