class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # find the last position stop decreasing, pos i
        # find the smallest larger value pos j
        # exchange the values in the positions
        # reverse the part after index i
        i = len(nums) - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        if i >= 0:
            # find j
            j = len(nums) - 1
            min_val = float('inf')
            min_idx = -1
            while j > i:
                if nums[j] > nums[i] and nums[j] < min_val:
                    min_val = nums[j]
                    min_idx = j
                j -= 1
            # exchange
            nums[i], nums[min_idx] = nums[min_idx], nums[i]
            # # reverse
            nums[i + 1:] = nums[i + 1:][::-1]
        else: 
            nums.reverse()
        return nums