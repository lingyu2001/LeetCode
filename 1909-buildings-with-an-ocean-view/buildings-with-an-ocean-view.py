class Solution(object):
    def findBuildings(self, heights):
        """
        :type heights: List[int]
        :rtype: List[int]
        """
        stack = []
        res = []
        for i in range(len(heights)-1, -1,-1):
            while stack and heights[stack[-1]] < heights[i]:
                stack.pop()
            if not stack:
                res.append(i)
            stack.append(i)
        res.sort()
        return res