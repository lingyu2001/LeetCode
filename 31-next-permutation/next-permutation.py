class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # 5 3  2 1 4
        n = len(nums) - 1
        i = n - 1
        j = n
        while i >= 0 and nums[i] >= nums[j] :
            i -= 1
            j -= 1
        if i < 0:
            nums.reverse()
        else:
            val = 101
            idx = -1
            for k in range(i + 1, n + 1):
                if nums[k] > nums[i]:
                    if nums[k] <= val:
                        idx = k
                        val = nums[k]
            nums[i], nums[idx] = nums[idx], nums[i]
            i += 1
            j = n
            while (i < j):
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j -= 1