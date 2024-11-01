class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        queue = deque([0])
        seen = set()
        while queue:
            start = queue.popleft()
            if start == len(s):
                return True
            for end in range(start + 1, len(s) + 1):
                if end in seen:
                    continue
                if s[start:end] in wordDict:
                    queue.append(end)
                    seen.add(end)
        return False
        