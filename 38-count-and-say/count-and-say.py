class Solution:
    def countAndSay(self, n: int) -> str:
        cur_str = "1"
        for _ in range(n - 1):
            i = 0
            j = 0
            next_str = ""
            while i < len(cur_str):
                j = i
                # cur_str[j] == cur_str[i]
                while j < len(cur_str) and cur_str[j] == cur_str[i]:
                    j += 1
                next_str += str(j - i) + cur_str[i]
                i = j
            cur_str = next_str 
        return cur_str