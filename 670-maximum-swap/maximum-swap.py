class Solution:
    def maximumSwap(self, num: int) -> int:
        s = str(num)
        map = {i:deque() for i in range (0,10)}
        s = list(s)
        for idx, c in enumerate(s,0):
            map[int(c)].append(idx)
        p = 9
        for idx, c in enumerate(s, 0):
            while p >= 0 and len(map[p]) == 0:
                p -= 1
            if p < 0:
                return num
            if int(c) >= p:
                map[p].popleft()
                continue
            else:
                swap_idx = map[p].pop()
                s[swap_idx], s[idx] = s[idx], s[swap_idx]
                res = ""
                for c in s:
                    res += c
                return int(res)
        return num
