# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ma = defaultdict(list)
        queue = deque()
        if root:
            queue.append((root, 0))
        while queue:
            size = len(queue)
            for _ in range(size):
                node, num = queue.popleft()
                ma[num].append(node.val)
                if node.left:
                    queue.append((node.left, num - 1))
                if node.right:
                    queue.append((node.right, num + 1))
        keys = list(ma.keys())
        keys.sort()
        return [ma[k] for k in keys]