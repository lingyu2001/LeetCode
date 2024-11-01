# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        pq = []
        for lst in lists:
            if lst:
                heapq.heappush(pq, (lst.val, lst))
        dummy = ListNode()
        p = dummy
        while pq:
            val, lst = heapq.heappop(pq)
            p.next = lst
            p = p.next
            lst = lst.next
            if lst:
                heapq.heappush(pq, (lst.val, lst))
        return dummy.next


        