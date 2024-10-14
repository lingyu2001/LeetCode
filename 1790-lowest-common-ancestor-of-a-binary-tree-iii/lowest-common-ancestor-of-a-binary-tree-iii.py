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
        while m != n:
            m = m.parent if m.parent else q
            n = n.parent if n.parent else p
        return m