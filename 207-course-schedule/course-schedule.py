class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # build the graph
        graph = defaultdict(list)
        for class_no, prereq in prerequisites:
            graph[class_no].append(prereq)
        # use DFS to detect if cyclic
        seen = [0] * numCourses
        for i in range(numCourses):
            if seen[i] == 0 and self.detectCycle(graph, i, seen):
                return False
        return True

    def detectCycle(self, graph, i, seen):
        if seen[i] == 1: 
            return True
        if seen[i] == 2:
            return False
        seen[i] = 1
        children = graph[i]
        for node in children:
            if self.detectCycle(graph, node, seen):
                return True
        seen[i] = 2
        return False
