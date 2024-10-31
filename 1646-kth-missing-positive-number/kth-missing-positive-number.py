class Solution(object):
    def findKthPositive(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        for i in range(1, arr[-1] + k + 1):
            if i not in arr:
                k -= 1
                if k == 0:
                    return i
            
        