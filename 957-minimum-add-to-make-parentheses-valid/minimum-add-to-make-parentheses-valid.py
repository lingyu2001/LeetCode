class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        res = 0
        lst = []
        for c in s:
            if c == "(":
                lst.append(c)
            else:
                if len(lst) == 0:
                    res += 1
                else:
                    lst.pop()
        return res+len(lst)