class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        list1 = []
        heapq.heapify(list1)
        for i,j in points:
            heapq.heappush(list1, (i*i+j*j, i, j))
        res = []
        for i in range(k):
            a,b,c = heapq.heappop(list1)
            res += [[b,c]]
        return res

        