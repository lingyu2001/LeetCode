"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution(object):
    def insert(self, head, insertVal):
        """
        :type head: Node
        :type insertVal: int
        :rtype: Node
        """
        if not head:
            head = Node(insertVal)
            head.next = head
            return head
        prev = head
        cur = head.next
        # prev <= insertVal <= cur
        # prev < insertVal insertVal > cur
        # prev > insertVal insertVal < cur
        while True:
            if prev.val <= insertVal <= cur.val:
                break
            if prev.val > cur.val:
                if (prev.val < insertVal and insertVal > cur.val) or (prev.val > insertVal and insertVal < cur.val):
                    break
            prev, cur = cur, cur.next
            if prev == head:
                break
        prev.next = Node(insertVal, cur)
        return head
