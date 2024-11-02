class Solution(object):
    def kClosest(self, points, k):
        """
        :type points: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        list1 = []
        heapq.heapify(list1)
        for i,j in points:
            heapq.heappush(list1, (-(i*i+j*j), i, j))
            if len(list1) > k:
                heapq.heappop(list1)
        res = []
        for i in range(k):
            a,b,c = heapq.heappop(list1)
            res += [[b,c]]
        return res