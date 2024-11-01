# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        path = 0
        nums = []
        self.dfs(root, path, nums)
        return sum(nums)

    def dfs(self, root, path, res):
        if not root:
            return 
        # leaf
        path = path * 10 + root.val
        if not root.left and not root.right:
            res.append(path)
        # not leaf
        if root.left:
            self.dfs(root.left, path, res)
        if root.right:
            self.dfs(root.right, path, res)
        path = path // 10