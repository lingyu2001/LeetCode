"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        node_map = defaultdict(Node)
        p = head
        # copy nodes
        while p:
            node_map[p] = Node(p.val)
            p = p.next
        # connect next
        p = head
        while p:
            copy = node_map[p]
            if p.next:
                copy.next = node_map[p.next]
            if p.random:
                copy.random = node_map[p.random]
            p = p.next
        return node_map[head] if head else None
        