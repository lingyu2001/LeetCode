class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        i = 0
        j = 0
        n1 = 0
        res = 0
        while j < len(nums):
            if nums[j] == 1:
                n1 += 1
            if j - i + 1 - n1 <= k:
                res = max(res, j - i + 1)
                j += 1
            else:
                if nums[i] == 1:
                    n1 -= 1
                i += 1
        return res
