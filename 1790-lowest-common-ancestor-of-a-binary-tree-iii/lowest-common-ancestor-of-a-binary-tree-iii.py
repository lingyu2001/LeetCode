"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        m = p
        n = q
        visited = set()
        while m :
            visited.add(m)
            m = m.parent
        while n:
            if n in visited:
                return n
            else:
                visited.add(n)
                n = n.parent
        return None