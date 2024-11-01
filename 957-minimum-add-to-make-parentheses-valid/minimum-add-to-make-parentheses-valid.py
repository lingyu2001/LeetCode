class Solution(object):
    def minAddToMakeValid(self, s):
        """
        :type s: str
        :rtype: int
        """
        left = 0
        right = 0
        res = 0
        for c in s:
            if c == '(':
                left += 1
            elif c == ')':
                right += 1
            if left < right:
                res += (right - left)
                left = right = 0
        if left > right:
            res += (left - right)
        return res