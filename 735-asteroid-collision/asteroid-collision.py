class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        res = []
        i = 0
        while i < len(asteroids):
            if not res:
                res.append(asteroids[i])
                i += 1
            else:
                if res[-1] > 0 and asteroids[i] < 0:
                    if abs(res[-1]) > abs(asteroids[i]):
                        i += 1
                    elif abs(res[-1]) == abs(asteroids[i]):
                        res.pop()
                        i += 1
                    else:
                        res.pop()
                else:
                    res.append(asteroids[i])
                    i += 1
        return res
                    
