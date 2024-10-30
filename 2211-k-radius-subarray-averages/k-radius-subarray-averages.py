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
        preSum = [0] * (n + 1)
        for i in range(1, n + 1):
            preSum[i] = preSum[i - 1] + nums[i - 1]
        res = [-1] * n
        for i in range(k, n - k):
            # get total sum within the range
            # i, [i-k,i+k], # of elems: 2k+1 
            total =  preSum[i + k + 1] - preSum[i - k]
            avg = total // (2 * k + 1)
            res[i] = avg
        return res

        