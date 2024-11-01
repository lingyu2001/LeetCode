class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        p1 = 0
        p2 = 0
        m = len(word1)
        n = len(word2)
        res = ""
        while p1 < m and p2 < n:
            res += word1[p1]
            p1 += 1
            res += word2[p2]
            p2 += 1
        if p1 < m:
            res += word1[p1:]
        if p2 < n:
            res += word2[p2:]
        return res
        