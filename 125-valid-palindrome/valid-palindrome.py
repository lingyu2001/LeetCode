class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        lo = 0 
        hi = len(s) - 1
        s = s.lower()
        while lo < hi:
            while lo < hi and not self.isAlphanumeric(s[lo]):
                lo += 1
            while lo < hi and not self.isAlphanumeric(s[hi]):
                hi -= 1
            if lo >= hi:
                return True
            elif s[lo] == s[hi]:
                lo += 1
                hi -= 1
            else:
                return False
        return True
    def isAlphanumeric(self, c):
        return '0'<=c<='9' or 'a'<=c<='z'
