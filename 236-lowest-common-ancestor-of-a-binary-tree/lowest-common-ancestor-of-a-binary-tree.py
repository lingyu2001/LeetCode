# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        self.ans = None
        self.helper(root, p, q)
        return self.ans
        
    def helper(self, node, p ,q):
        if not node:
            return False
        left = self.helper(node.left, p, q)
        right = self.helper(node.right, p, q)
        mid = node == p or node == q
        if mid + left + right >= 2:
            self.ans = node
        return mid or left or right
        