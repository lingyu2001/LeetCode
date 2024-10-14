import random
class Solution:
    def __init__(self, w: List[int]):
        self.preSum = [0]
        # calculate preSum array
        for c in w:
            self.preSum.append(self.preSum[-1] + c)
    def pickIndex(self) -> int:
        # generate a number m between 1 and preSum[-1]
        num = random.randint(1, self.preSum[-1])
        # binary search
        lo = 0
        hi = len(self.preSum)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if self.preSum[mid] < num:
                lo = mid + 1
            else:
                hi = mid
        return lo - 1


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()