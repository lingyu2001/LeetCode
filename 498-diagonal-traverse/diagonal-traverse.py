class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        if not mat or not mat[0]:
            return []
        N,M = len(mat), len(mat[0])
        r = 0
        c = 0
        direction = 1
        res = []
        while r < N and c < M:
            res.append(mat[r][c])
            if direction:
                newr = r - 1
                newc = c + 1
            else:
                newr = r + 1
                newc = c - 1
            # if newr and newc is valid
            if newr < 0 or newr >= N or newc < 0 or newc >= M:
                if direction:
                    r += (c == M - 1)
                    c += (c < M - 1)
                else:
                    c += (r == N - 1)
                    r += (r < N - 1)
                direction = 1 - direction
            else:
                r = newr
                c = newc
        return res