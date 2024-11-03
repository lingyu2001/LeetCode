class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            s1 = self.expand(s, i, i)
            s2 = self.expand(s, i, i + 1)
            res = s1 if len(res) < len(s1) else res
            res = s2 if len(res) < len(s2) else res
        return res

    def expand(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return s[l + 1:r]