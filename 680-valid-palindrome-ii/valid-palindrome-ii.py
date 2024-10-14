class Solution:
    def validPalindrome(self, s: str) -> bool:
        i, j = 0, len(s) - 1
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                if i == j - 1:
                    return True
                return self.isPalindrome(s[i:j]) or self.isPalindrome(s[i+1:j+1])
        return True


    def isPalindrome(self, s:str) -> bool:
        i = 0
        j = len(s) - 1
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                return False
        return True