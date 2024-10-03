# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sum = 0
    path = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root)
        return self.sum
    def helper(self, root):
        if root == None:
            return
        self.path = self.path * 10 + root.val
        if root.left == None and root.right == None:
            self.sum += self.path
            self.path = self.path // 10 
            return
        self.helper(root.left)
        self.helper(root.right)
        self.path = self.path // 10 
        return 
        