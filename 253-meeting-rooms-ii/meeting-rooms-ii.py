class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        intervals.sort()
        l = []
        heapq.heapify(l)
        res = 0
        for i, j in intervals:
            if len(l) == 0:
                heapq.heappush(l, j)
            else:
                while len(l) > 0 and i >= l[0]:
                    heapq.heappop(l)
                heapq.heappush(l, j)
            res = max(res, len(l))
        return res

