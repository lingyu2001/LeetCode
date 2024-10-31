class Solution(object):
    def findBuildings(self, heights):
        """
        :type heights: List[int]
        :rtype: List[int]
        """
        # find the buildings
        res = []
        max_h = 0
        for i in range(len(heights) - 1, -1, -1):
            if heights[i] > max_h:
                res.append(i)
                max_h = heights[i]
        res.sort()
        return res
        # sort it 
        