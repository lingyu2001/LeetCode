# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    cnt = 0
    ans = 0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.helper(root, k)
        return self.ans
    def helper(self, root, k):
        if not root: 
            return None
        self.helper(root.left,k)
        self.cnt += 1
        if self.cnt == k:
            self.ans = root.val
        else:
            self.kthSmallest(root.right,k)