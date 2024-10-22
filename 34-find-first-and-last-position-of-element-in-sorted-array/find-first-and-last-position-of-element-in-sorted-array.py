class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0: 
            return [-1, -1]
        i = self.binsearch_left(nums, target)
        j = self.binsearch_right(nums, target)
        print(i, j)
        if i >= len(nums) or nums[i] != target or nums[j-1] != target:
            return [-1,-1]
        else:
            return [i, j-1]

    def binsearch_left(self, nums, target):
        lo = 0
        hi = len(nums)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid
        return lo
    
    def binsearch_right(self, nums, target):
        lo = 0
        hi = len(nums)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] <= target:
                lo = mid + 1
            else:
                hi = mid
        return lo
    