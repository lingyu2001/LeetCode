class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = set()  # Use a set to avoid duplicate triplets
        nums = sorted(nums)
        
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            target = -nums[i]
            j = i + 1
            k = len(nums) - 1
            
            while j < k:
                current_sum = nums[j] + nums[k]
                if current_sum == target:
                    res.add((nums[i], nums[j], nums[k]))  # Add the triplet as a tuple to the set
                    while j < k and nums[j] == nums[j + 1]:
                        j += 1
                    while j < k and nums[k] == nums[k - 1]:
                        k -= 1
                    j += 1
                    k -= 1
                elif current_sum > target:
                    k -= 1
                else:
                    j += 1
        
        return [list(triplet) for triplet in res] 
