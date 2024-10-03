class Solution:
    def customSortString(self, order: str, s: str) -> str:
        l = list(s)
        res = ""
        for c in order:
            while c in l:
                res += c
                l.remove(c)
        for c in l:
            res += c
        return res
        