class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        presum = 0
        table = {0:-1}
        for i, n in enumerate(nums):
            presum += n
            if presum % k in table:
                if i - table[presum % k] >= 2:
                    return True
            else:
                table[presum % k] = i
        return False
