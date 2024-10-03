class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        res = 0
        n = len(nums)
        preSum = [0] * (n + 1)
        count = {0:1}
        for i in range(1, n + 1):
            preSum[i] = preSum[i - 1] + nums[i - 1]
            lookfor = preSum[i] - k
            if lookfor in count:
                res += count[lookfor]
            if preSum[i] in count:
                count[preSum[i]] += 1
            else:
                count[preSum[i]] = 1
        return res
        