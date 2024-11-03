class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        directions = [[-2,-1], [-1,-2], [1,-2],[2,-1], [-2,1], [-1,2],[1,2],[2,1]]
        queue = deque()
        queue.append((0,0))
        res = -1
        seen = set()
        while queue:
            sz = len(queue)
            res += 1
            for _ in range(sz):
                i, j = queue.popleft()
                seen.add((i, j))
                if i == x and y == j:
                    return res
                for di, dj in directions:
                    newi = i + di
                    newj = j + dj
                    if (newi,newj) not in seen:
                        queue.append((newi, newj))
                        seen.add((newi, newj))
