"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        node_map = defaultdict(Node)
        # create node maps: origin -> copy
        self.dfs(node, node_map)
        # add neighbors
        seen = set()
        self.add_neighbors(node, node_map, seen)
        return node_map[node] if node else None

    def dfs(self, node, node_map):
        if not node or node in node_map:
            return
        node_map[node] = Node(node.val)
        for nei in node.neighbors:
            self.dfs(nei, node_map)
        
    def add_neighbors(self, node, node_map, seen):
        if not node or node in seen:
            return 
        copy = node_map[node]
        seen.add(node)
        copy.neighbors = []
        for nei in node.neighbors:
            copy.neighbors.append(node_map[nei])
            self.add_neighbors(nei, node_map, seen)
        