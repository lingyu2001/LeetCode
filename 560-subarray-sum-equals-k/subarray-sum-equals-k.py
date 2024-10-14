class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        preSum = defaultdict(int)
        sum = 0
        res = 0
        preSum[0] = 1 
        for n in nums:
            sum += n
            if sum - k in preSum:
                res += preSum[sum - k]
            preSum[sum] += 1
        return res