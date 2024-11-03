class Solution:
    def minWindow(self, s: str, t: str) -> str:
        end = 0
        dict_t = Counter(t)
        required = len(dict_t)
        window = defaultdict(int)
        formed = 0
        l = 0
        r = 0
        res = float('inf'), None, None
        # extend the window
        while r < len(s):
            # add 
            window[s[r]] += 1
            if s[r] in dict_t and dict_t[s[r]] == window[s[r]]:
                formed += 1
            # shrink the window
            while l <= r and formed == required:
                if r - l + 1 < res[0]:
                    res = r - l + 1, l, r
                left_char = s[l]
                # update window data
                window[left_char] -= 1
                if left_char in dict_t and window[left_char] < dict_t[left_char]:
                    formed -= 1
                l += 1
            r += 1
        if res[0] != float('inf'):
            return s[res[1]:res[2] + 1]
        else:
            return ""