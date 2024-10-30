class Solution(object):
    def findRLEArray(self, encoded1, encoded2):
        """
        :type encoded1: List[List[int]]
        :type encoded2: List[List[int]]
        :rtype: List[List[int]]
        """
        res = []
        p1 = 0
        p2 = 0
        m = len(encoded1)
        n = len(encoded2)
        while p1 < m and p2 < n:
            num_add = min(encoded1[p1][1], encoded2[p2][1])
            prod = encoded1[p1][0] * encoded2[p2][0]
            if res and res[-1][0] == prod:
                res[-1][1] += num_add
            else:
                res.append([prod, num_add])
            encoded1[p1][1] -= num_add
            encoded2[p2][1] -= num_add
            if encoded1[p1][1] == 0:
                p1 += 1
            if encoded2[p2][1] == 0:
                p2 += 1
        return res
        