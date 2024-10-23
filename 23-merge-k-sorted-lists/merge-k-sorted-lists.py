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
        # nlogk
        # k
        # put all elements in the queue
        pq = []
        for i in lists:
            if i:
                heapq.heappush(pq, (i.val, i))
        # lists = [[1,4,5],[1,3,4],[2,6]]
        # pq:
        (5,[5])
        head = pointer = ListNode(0)
        # get the smallest Listnode each time when poping
        while pq:  #      (4,[4])
            val, lst = heapq.heappop((pq))
            # add the first node of the list to res linkedlist
            node = lst # [4]
            lst = lst.next #[]
            pointer.next = node #[0,1,1,2,3,4,4]
            pointer = pointer.next # 4, indx=5
            if lst:
                heapq.heappush(pq, (lst.val, lst))
        return head.next
        