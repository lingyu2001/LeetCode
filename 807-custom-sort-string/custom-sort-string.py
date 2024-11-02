class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        cnter = Counter(s)
        res = []
        for c in order:
            if c in cnter:
                res += [c] * cnter[c]
                del cnter[c]
        for c,f in cnter.items():
            res += [c] * f
        return "".join(res)