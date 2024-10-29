class Solution(object):
    def longestCommonPrefix(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: int
        """
        # build prefix set for arr1
        prefix = set()
        for n in arr1:
            while n > 0:
                prefix.add(n)
                n = n // 10
        # find the longest matching prefix in arr2
        res = 0
        for n in arr2:
            while n > 0:
                if n in prefix:
                    if res < len(str(n)):
                        res = len(str(n))
                    break
                else:
                    n = n // 10
        return res

        