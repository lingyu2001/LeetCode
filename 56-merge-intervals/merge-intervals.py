class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        res = []
        intervals.sort()
        for i, j in intervals:
            if not res:
                res.append([i,j])
            elif res[-1][1] < i:
                res.append([i,j])
            elif res[-1][1] >= i:
                res[-1][0] = min(res[-1][0], i)
                res[-1][1] = max(res[-1][1], j)
        return res