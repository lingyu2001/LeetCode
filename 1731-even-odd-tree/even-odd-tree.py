# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def verify(self, level, node, val):
        if (level % 2 == 0 and node.val % 2 ==1) or (level % 2 == 1 and node.val % 2 == 0):
            if level % 2 == 0:
                return node.val > val
            else:
                return node.val < val
        else:
            return False
    def isEvenOddTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        queue = deque()
        if root:
            queue.append(root)
        level = -1
        while queue:
            level += 1
            size = len(queue)
            val = float('-inf') if level % 2 == 0 else float('inf')
            for _ in range(size):
                node = queue.popleft()
                if self.verify(level, node, val):
                    val = node.val
                    if node.left :
                        queue.append(node.left)
                    if node.right:
                        queue.append(node.right)
                else:
                    return False
        return True


