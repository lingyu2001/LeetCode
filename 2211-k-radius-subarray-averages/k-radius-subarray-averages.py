class Solution(object):
    def getAverages(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        n = len(nums)
        res = [-1] * n
        if n < 2 * k + 1:
            return res
        window_sum = 0
        lo = 0
        hi = 2 * k
        for i in range(lo, hi):
            window_sum += nums[i]
        while hi < n:
            window_sum += nums[hi]
            i = lo + (hi - lo) // 2
            res[i] = window_sum // (2 * k + 1)
            window_sum -= nums[lo]
            lo += 1
            hi += 1

        return res
        