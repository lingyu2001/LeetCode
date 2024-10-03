from collections import deque

class Solution(object):
    directions = [
        [1, 0], [0, 1], [-1, 0], [0, -1],
        [1, 1], [1, -1], [-1, 1], [-1, -1]
    ]

    def shortestPathBinaryMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        
        if grid[0][0] == 1 or grid[n - 1][n - 1] == 1:
            return -1

        # BFS initialization
        queue = deque([(0, 0, 1)])  # (row, column, distance)
        visited = set((0, 0))

        while queue:
            x, y, dist = queue.popleft()

            # If we've reached the bottom-right corner, return the distance
            if x == n - 1 and y == n - 1:
                return dist

            # Explore all 8 possible directions
            for dx, dy in self.directions:
                nx, ny = x + dx, y + dy

                # Check if the new position is valid and not visited
                if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 0 and (nx, ny) not in visited:
                    visited.add((nx, ny))
                    queue.append((nx, ny, dist + 1))

        return -1  # If there is no path
