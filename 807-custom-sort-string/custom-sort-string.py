class Solution:
    def customSortString(self, order: str, s: str) -> str:
        lst = list(s)
        lst.sort()
        res = ""
        for c in order:
            while c in lst:
                res += c
                lst.remove(c)
        while len(lst) != 0:
            res += lst.pop()
        return res
