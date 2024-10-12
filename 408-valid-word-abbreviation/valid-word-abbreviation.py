class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        ws = [c for c in word if c != ' ']
        m, n = len(ws), len(abbr)
        i, j = 0, 0
        while i < m and j < n:
            if ws[i] == abbr[j]:
                i += 1
                j += 1
            elif abbr[j] == '0':
                return False
            elif abbr[j].isnumeric():
                k = j
                while k < n and abbr[k].isnumeric():
                    k += 1
                length = int(abbr[j:k])
                i = i + length
                j = k
            else:
                return False
        return i == m and j == n