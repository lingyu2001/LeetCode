class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if not p:
            return not s
        # This variable helps determine if we should attempt to match the current character(s) in text and pattern.
        first_match = False
        if s:
            if p[0] == '.' or s[0] == p[0]:
                first_match = True
        if len(p) >= 2 and p[1] == '*':
             # Case 1: Treat '*' as matching zero occurrences
             # Case 2: Treat '*' as matching one or more occurrences
            return self.isMatch(s, p[2:]) or (first_match and self.isMatch(s[1:], p))
        else:
            return first_match and self.isMatch(s[1:], p[1:])
