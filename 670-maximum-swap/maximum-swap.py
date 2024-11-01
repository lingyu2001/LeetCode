class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        nums = list(str(num))
        n = len(nums)
        max_index = n - 1
        left = -1 
        right = -1
        for i in range(n - 2, -1, -1):
            if nums[i] > nums[max_index]:
                max_index = i
            elif nums[i] < nums[max_index]:
                left,right = i, max_index
        if left != -1:
            nums[left], nums[right] = nums[right], nums[left]
            return int("".join(nums))
        return num
            