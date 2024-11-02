class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lo = 1
        hi = max(piles)
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if self.verify(piles, mid, h):
                hi = mid - 1
            else:
                lo = mid + 1
        return lo
    def verify(self, piles, speed, h):
        res = 0
        for i in piles:
            res += (math.ceil(i / speed))
        return res <= h