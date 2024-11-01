# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rangeSumBST(self, root, low, high):
        """
        :type root: Optional[TreeNode]
        :type low: int
        :type high: int
        :rtype: int
        """
        res = [0]
        self.helper(root, low, high, res)
        return res[0]
    
    def helper(self, root, low, high, res):
        if not root:
            return 
        if root.val > low:
            self.helper(root.left, low, high, res)
        if low <= root.val <= high:
            res[0] += root.val
        if root.val < high:
            self.helper(root.right, low, high, res)
        