class Solution:
    def countAndSay(self, n: int) -> str:
        cur_str = "1"
        for _ in range(n - 1):
            next_str = ""
            j = 0
            k = 0
            while j < len(cur_str):
                while (k < len(cur_str) and cur_str[k] == cur_str[j]):
                    k += 1
                next_str += str(k - j) + cur_str[j]
                j = k
            cur_str = next_str
        return cur_str

        