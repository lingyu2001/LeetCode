# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isEvenOddTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        queue = deque()
        if root:
            queue.append([root, 0])
        while queue:
            size = len(queue)
            compare = float('inf') if queue[0][1] % 2 == 1 else float('-inf')
            for i in range(size):
                node, level = queue.popleft()
                if level % 2 == node.val % 2:
                    return False
                if level % 2 == 1:
                    if node.val >= compare:
                        return False
                    else:
                        compare = node.val
                else:
                    if node.val <= compare:
                        return False
                    else:
                        compare = node.val
                if node.left:
                    queue.append([node.left, level + 1])
                if node.right:
                    queue.append([node.right, level + 1])
        return True

                  
        