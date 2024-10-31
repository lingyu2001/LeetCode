class Solution(object):
    def findKthPositive(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        missing = [0] * len(arr)
        # num of positive integers missing before arr[i]
        for i in range(len(arr)):
            missing[i] = arr[i] - (i + 1)
        # find the range of the kth pos integer
        lo = 0 
        hi = len(missing)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if missing[mid] >= k:
                hi = mid
            else:
                lo = mid + 1
        # lo = hi
        return lo + k
         