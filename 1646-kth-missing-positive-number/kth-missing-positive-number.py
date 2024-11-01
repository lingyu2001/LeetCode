class Solution(object):
    def findKthPositive(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        missing = [0] * len(arr)
        for i in range(1, len(arr) + 1):
            missing[i - 1] = arr[i - 1] - i
        # print(missing)
        # find the position of k
        lo = 0
        hi = len(arr)
        while lo < hi:
            mid = lo + (hi - lo) // 2
            # leftmost
            if missing[mid] < k:
                lo = mid + 1
            else:
                hi = mid
        return  lo + k
        