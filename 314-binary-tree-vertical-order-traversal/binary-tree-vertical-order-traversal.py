# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        map = defaultdict(list)
        queue = deque()
        if root:
            queue.append((root, 0))
        while queue:
            size  = len(queue)
            # get all nodes in current level
            for _ in range(size):
                node, idx = queue.popleft()
                # add node to map based on idx
                map[idx].append(node.val)
                # add left child node and right child node
                if node.left:
                    queue.append((node.left, idx - 1))
                if node.right:
                    queue.append((node.right, idx + 1))
        keys = list(map.keys())
        keys.sort()
        return [map[k] for k in keys]