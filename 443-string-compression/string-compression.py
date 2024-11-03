class Solution:
    def compress(self, chars: List[str]) -> int:
        i = 0
        j = 0
        while j < len(chars):
            cnt = 0
            k = j
            while k < len(chars) and chars[k] == chars[j]:
                k += 1
                # a, a, b
            cnt = k - j
            # move char
            chars[i] = chars[j]
            # change it to frequency
            i += 1
            if cnt > 1:
                chars[i: i + len(str(cnt))] = list(str(cnt))
                i = i + len(str(cnt))
            j = k
        return i

