"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution(object):
    def treeToDoublyList(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None
        self.first, self.last = None, None
        self.helper(root)
        self.first.left = self.last
        self.last.right = self.first
        return self.first

    def helper(self,  root):
        if root:
            self.helper(root.left)
            if self.last:
                self.last.right = root
                root.left = self.last
            else:
                self.first = root
            self.last = root
            self.helper(root.right)