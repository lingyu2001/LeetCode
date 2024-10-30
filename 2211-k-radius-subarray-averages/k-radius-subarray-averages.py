class Solution(object):
    def getAverages(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # define a presum
        # define a res arr = [-1] * len()
        # start from k to len() - k
        n = len(nums)
        total = 0
        lo = 0
        hi = 2 * k
        res = [-1] * n
        for i in range(lo, hi + 1):
            if i < n:
                total += nums[i]
            else:
                return res
        for i in range(k, n - k):
            # get total sum within the range
            # i, [i-k,i+k], # of elems: 2k+1 
            avg = total // (2 * k + 1)
            res[i] = avg
            if hi + 1 < n:
                total -= nums[lo]
                lo += 1
                hi += 1
                total += nums[hi]
        return res

        