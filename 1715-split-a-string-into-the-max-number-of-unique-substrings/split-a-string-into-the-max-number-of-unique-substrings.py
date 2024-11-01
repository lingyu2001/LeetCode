class Solution(object):
    def maxUniqueSplit(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = [0]
        seen = set()
        self.helper(s, 0, seen, res)
        return res[0]
        
    def helper(self, s, idx, seen, res):
        if idx == len(s):
            res[0] = max(res[0], len(seen))
            return
        if len(s) - idx + len(seen) <= res[0]:
            return 
        for end in range(idx + 1, len(s) + 1):
            substr = s[idx:end]
            if substr not in seen:
                seen.add(substr)
                self.helper(s, end, seen, res)
                seen.remove(substr)
        