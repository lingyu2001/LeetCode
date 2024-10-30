class Solution(object):
    res = 0
    def maxUniqueSplit(self, s):
        """
        :type s: str
        :rtype: int
        """
        split = set()
        self.helper(s, 0, split)
        return self.res

    def helper (self, s, start, seen):
        if start >= len(s):
            self.res = max(self.res, len(seen))
            return
        
        for end in range(start + 1, len(s) + 1):
            substring = s[start : end]
            if substring not in seen:
                seen.add(substring)
                self.helper(s, end, seen)
                seen.remove(substring)





        