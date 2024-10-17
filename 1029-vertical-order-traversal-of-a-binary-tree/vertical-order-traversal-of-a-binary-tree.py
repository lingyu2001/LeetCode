# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        idx_to_pos = defaultdict(list)
        pos_to_val = defaultdict(list)
        queue = deque()
        if root:
            queue.append((root, (0, 0)))
        while queue:
            # explore all nodes in the current level
            size = len(queue)
            for _ in range(size):
                node, (r, c) = queue.popleft()
                if (r,c) not in idx_to_pos[c]:
                    idx_to_pos[c].append((r,c))
                pos_to_val[(r,c)].append(node.val)
                if node.left:
                    queue.append((node.left, (r+1, c-1)))
                if node.right:
                    queue.append((node.right, (r+1, c+1)))
        keys = list(idx_to_pos.keys())
        keys.sort()
        res = []
        for idx in keys:
            positions = idx_to_pos[idx]
            values = []
            for r, c in positions:
                values += sorted(pos_to_val[(r,c)])
            res.append(values)
        return res
