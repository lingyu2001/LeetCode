class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        if n == 2:
            return sum(nums) % k == 0
        preSum = [0 for i in range(n + 1)]
        for i in range(1, n + 1):
            preSum[i] = preSum[i - 1] + nums[i - 1]
        map = {0:0}
        for i in range (1, n + 1):
            if  (preSum[i] % k) in map:
                if i - map[preSum[i] % k] >= 2:
                    return True
            else:
                map[preSum[i] % k] = i
        return False