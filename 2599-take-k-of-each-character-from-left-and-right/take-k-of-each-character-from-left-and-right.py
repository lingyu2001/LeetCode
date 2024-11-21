class Solution(object):
    def takeCharacters(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        cnt = Counter(s)
        # cnt = [0] * 3
        # for c in s:
        #     cnt[ord(c) - ord("a")] += 1
        if k == 0:
            return 0
        if len(cnt) < 3:
            return -1
        for _,v in cnt.items():
            if v < k:
                return -1
        # for i in range(3):
        #     if cnt[i] < k:
        #         return -1
        window = [0] * 3
        l = 0
        max_window = 0
        for r in range(len(s)):
            # add to window
            window[ord(s[r]) - ord('a')] += 1
            # shrink
            while l <= r and  (
                cnt['a'] - window[0] < k or 
                cnt['b'] - window[1] < k or 
                cnt['c'] - window[2] < k
            ):
                window[ord(s[l]) - ord('a')] -= 1
                l += 1
            max_window = max(max_window, r - l + 1)
        return len(s) - max_window




        