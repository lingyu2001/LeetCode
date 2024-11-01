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
        while p1 < min(m, n):
            res += word1[p1]
            res += word2[p1]
            p1 += 1
        if p1 < m:
            res += word1[p1:]
        if p1 < n:
            res += word2[p1:]
        return res
        