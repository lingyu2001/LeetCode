class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        """
        When reading from right to left, 
        if the sequence is descending, 
        that part of the sequence represents the highest possible order for those elements (like [3, 2, 1]). 
        So, to get a larger permutation, we need to find where we can "break" this descending order to make a small increase.
        """
        # find the last increasing position
        i = len(nums) - 2
        while i >= 0:
            if nums[i] >= nums[i + 1]:
                i -= 1
            else:
                break
        if i >= 0:
            # find the smallest num greater than nums[i]
            j = len(nums) - 1
            while nums[j] <= nums[i]:
                j -= 1
            # swap
            nums[i], nums[j] = nums[j], nums[i]
            # reverse
        m = i + 1 
        n = len(nums) - 1
        while m < n:
            nums[m], nums[n] = nums[n], nums[m]
            m += 1
            n -= 1
            


