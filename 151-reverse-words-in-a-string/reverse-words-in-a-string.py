class Solution:
    def reverseWords(self, s: str) -> str:
        lo = 0
        hi = len(s) - 1
        # trim
        while lo < len(s) and s[lo] == ' ':
            lo += 1
        while hi >= 0 and s[hi] == ' ':
            hi -= 1
        output = []
        while lo <= hi:
            if s[lo] != ' ':
                output.append(s[lo])
            elif output[-1] != ' ':
                output.append(s[lo])
            lo += 1 
        s = output
        s = s[::-1]
        i = 0
        hi = len(s)
        while i < hi:
            j = i
            while j < hi and s[j] != ' ':
                j += 1
            s[i:j] = s[i:j][::-1]
            i = j + 1
        return "".join(s)
