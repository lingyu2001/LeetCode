class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        pq = []
        res = 0
        intervals.sort()
        for start, end in intervals:
            if not pq:
                heapq.heappush(pq, end)
            else:
                if pq[0] >= start:
                    heapq.heappush(pq, end)
                else:
                    heapq.heappop(pq)
                    heapq.heappush(pq, end)
            res = max(res, len(pq))
        return res