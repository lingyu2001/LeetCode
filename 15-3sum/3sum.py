class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        return self.nsum(nums, 3, 0, 0)
        
    def nsum(self, nums, n, start, target):
        sz = len(nums)
        res = []
        if n < 2 or sz < n:
            return []
        if n == 2:
            lo = start
            hi = sz - 1
            while lo < hi:
                if nums[lo] + nums[hi] == target:
                    res.append([nums[lo], nums[hi]])
                    lo += 1
                    while lo < sz and nums[lo] == nums[lo - 1]:
                        lo += 1
                    hi -= 1
                    while hi > lo and nums[hi] == nums[hi + 1]:
                        hi -= 1
                elif nums[lo] + nums[hi] < target:
                    lo += 1
                    while lo < sz and nums[lo] == nums[lo - 1]:
                        lo += 1
                else:
                    hi -= 1
                    while hi > lo and nums[hi] == nums[hi + 1]:
                        hi -= 1
            return res
        else:
            for i in range(start, sz):
                if i > start and nums[i] == nums[i - 1]:
                    continue
                sub_res = self.nsum(nums, n - 1, i + 1, target - nums[i])
                for arr in sub_res:
                    arr.append(nums[i])
                    res.append(arr)
            return res
            
