class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums = sorted(nums)
        for i in range(0, len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1] :
                continue
            target = -nums[i]
            # print(target)
            j = i + 1
            k = len(nums) - 1
            while j < k:
                # print(j, k , nums[j] + nums[k])
                if nums[j] + nums[k] == target:
                    res.append([nums[i], nums[j], nums[k]])
                    while j < k and nums[j + 1] == nums[j]:
                        j += 1
                    while j < k and nums[k - 1] == nums[k]:
                        k -= 1
                    j += 1
                    k -= 1
                elif nums[j] + nums[k] > target:
                    k -= 1
                else:
                    j += 1
        return res
                
