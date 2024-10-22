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
        head = ListNode(0)
        cur = head
        for i in lists:
            if i:
                heapq.heappush(pq, (i.val, i))
        
        # get the smallest number in the pq 
        while pq:
            sm_val, lst = heapq.heappop(pq)
            node = lst
            cur.next = lst
            cur = cur.next
            lst = lst.next
            # check if the lst still has values
            if lst:
                heapq.heappush(pq, (lst.val, lst))
        return head.next