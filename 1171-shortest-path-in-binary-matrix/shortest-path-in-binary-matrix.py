class Solution(object):
    directions = [
        [1, 0], [0, 1], [-1, 0], [0, -1],
        [1, 1], [1, -1], [-1, 1], [-1, -1]
    ]
    m = 0
    def shortestPathBinaryMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        self.m = len(grid)
        if grid[0][0] == 1 or grid[self.m - 1][self.m - 1] == 1:
            return -1
        return self.bfs(grid, 0, 0)

    def bfs(self, grid, i, j) :
        queue = deque([(i,j,1)])
        visited = set((0, 0))
        while queue:
            x,y,dist = queue.popleft()
            visited.add((x,y))
            if x == self.m - 1 and y == self.m - 1:
                return dist
            for a,b in self.directions:
                new_x = x + a
                new_y = y + b
                # Check boundaries and obstacles
                if (0 <= new_x < self.m and 
                    0 <= new_y < self.m and 
                    grid[new_x][new_y] == 0 and 
                    (new_x, new_y) not in visited):
                    queue.append((new_x, new_y, dist + 1))
                    visited.add((new_x, new_y))  # Mark as visited
        return -1

        
        