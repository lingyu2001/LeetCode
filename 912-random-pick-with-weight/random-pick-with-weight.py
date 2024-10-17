class Solution:

    def __init__(self, w: List[int]):
        self.preSum = [0]
        for c in w:
            self.preSum.append(self.preSum[-1] + c)

    def pickIndex(self) -> int:
        num = random.randint(1, self.preSum[-1])
        # use binary search to find the pos to insert
        lo = 1
        hi = len(self.preSum)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if self.preSum[mid] < num:
                lo = mid + 1
            else: 
                hi = mid
        return lo - 1
