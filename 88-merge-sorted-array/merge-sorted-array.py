class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i, j = m - 1 ,n - 1
        t = m + n - 1
        # move pointer and compare values
        while i >= 0 and j >= 0: 
            if nums1[i] >= nums2[j]:
                nums1[t] = nums1[i]
                t -= 1
                i -= 1
            else:
                # nums[j] is larger
                nums1[t] = nums2[j]
                t -= 1
                j -= 1
        # move the rest of values to nums1
        while i >= 0:
            nums1[t] = nums1[i]
            t -= 1
            i -= 1
        while j >= 0:
            nums1[t] = nums2[j]
            t -= 1
            j -= 1
        return nums1
        