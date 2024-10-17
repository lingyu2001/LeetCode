class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        directions = [
            [1, 0], [0, 1], [-1, 0], [0, -1],
            [1, 1], [1, -1], [-1, 1], [-1, -1]
        ]
        depth = 0
        n = len(grid)
        if grid[0][0] == 1 or grid[n-1][n-1] == 1:
            return -1
        visited = set()
        queue = deque()
        queue.append((0,0))
        while queue:
            size = len(queue)
            depth += 1
            # explore all cells at the current depth
            for _ in range(size):
                i,j = queue.popleft()
                visited.add((i,j))
                if i == n - 1 and j == n - 1:
                    return depth
                for a,b in directions:
                    newi = i + a
                    newj = j + b
                    # validate (newi,newj)
                    if 0 <= newi < n and 0 <= newj < n and grid[newi][newj] == 0 and (newi, newj) not in visited:
                        queue.append((newi, newj))
                        visited.add((newi, newj))
        return -1
        