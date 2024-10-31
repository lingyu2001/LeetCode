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
        p = head
        if not p:
            head = Node(insertVal, None)
            head.next = head
            return head
        next = p.next
        prev, cur = head, head.next
        while True:
            if prev.val <= insertVal <= cur.val:
                break
            elif prev.val > cur.val:
                if insertVal >= prev.val or insertVal <= cur.val:
                    break
            prev, cur = cur, cur.next
            if prev == head:
                break
            
        prev.next = Node(insertVal, cur)
        return head

        
		