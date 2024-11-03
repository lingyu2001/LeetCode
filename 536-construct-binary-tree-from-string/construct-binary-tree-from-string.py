# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def get_num(self, s, idx):
        is_neg = False
        if idx < len(s) and s[idx] == '-':
            is_neg = True
            idx += 1
        res = 0
        while idx < len(s) and s[idx].isdigit():
            res = 10 * res + int(s[idx])
            idx += 1
        return res if not is_neg else -res, idx
        
    def str2tree(self, s: str) -> Optional[TreeNode]:
        return self.helper(s, 0)[0]

    def helper(self, s, idx):
        if idx == len(s):
            return None, idx
        val, idx = self.get_num(s, idx)
        node = TreeNode(val)
        if idx < len(s) and s[idx] == '(':
            node.left, idx = self.helper(s, idx + 1)
        if node.left and idx < len(s) and s[idx] == '(':
            node.right, idx = self.helper(s, idx + 1)
        return node, idx + 1 if idx < len(s) and s[idx] == ')' else idx