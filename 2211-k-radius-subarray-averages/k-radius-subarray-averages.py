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
        hi = 2 * k + 1
        for i in range(lo, hi):
            window_sum += nums[i]
        res[k] = window_sum // (2 * k + 1)
        while hi < n:
            window_sum = window_sum + nums[hi] - nums[lo]
            res[hi - k] = window_sum // (2 * k + 1)
            lo += 1
            hi += 1
        return res
        