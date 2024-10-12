class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
            lst = list(s)
            stack = []
            # iterate every char in the string
            for idx, c in enumerate(lst):
                if ord('a') <= ord(c) <= ord('z'):
                    continue
                elif c == "(":
                    stack.append(idx)
                else :
                    if len(stack) == 0:
                        lst[idx] = ' '
                    else:
                        stack.pop()
            while len(stack) != 0:
                lst[stack.pop()] = ' '
            res = ""
            for c in lst:
                if c != ' ':
                    res = res+c
            return res