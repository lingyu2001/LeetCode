class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums:
            return [-1, -1]
        left = self.bisec_left(nums, target)
        if left >= len(nums) or nums[left] != target:
            return [-1, -1]
        right = self.bisec_right(nums, target)
        if nums[right - 1] != target:
            return [-1, -1]
        return [left, right - 1]
        
    def bisec_left(self, num, target):
        lo = 0
        hi = len(num)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if num[mid] >= target:
                hi = mid
            else:
                lo = mid + 1
        return lo
    
    def bisec_right(self, num, target):
        lo = 0
        hi = len(num)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if num[mid] > target:
                hi = mid
            else:
                lo = mid + 1
        return lo
