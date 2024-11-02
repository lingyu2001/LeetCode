class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.helper(nums, 0, [])
        return self.res
    def helper(self, nums, idx, temp):
        # if idx >= len(nums):
        #     return
        self.res.append(temp[:])
        for i in range(idx, len(nums)):
            temp.append(nums[i])
            self.helper(nums, i + 1, temp)
            temp.pop()
        