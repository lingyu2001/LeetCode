class Solution:
    def decodeString(self, s: str) -> str:
        self.idx = 0
        return self.helper(s)
        
    # def get_num(self, s, idx):
    #     res = 0
    #     while idx < len(s) and s[idx].isdigit():
    #         res = res * 10 + int(s[idx])
    #         idx += 1
    #     return res, idx

    # find the str before the next ]
    def helper(self, s):
        res = []
        while self.idx < len(s) and s[self.idx] != ']':
            # check if it is digit or not
            if not s[self.idx].isdigit():
                res += s[self.idx]
                self.idx += 1
            else:
                # get the k
                # k, idx = self.get_num(s, idx)
                k = 0
                while self.idx < len(s) and s[self.idx].isdigit():
                    k = k * 10 + int(s[self.idx])
                    self.idx += 1
                # ignore the [
                self.idx += 1
                # get the string
                substr = self.helper(s)
                # ignore ]
                self.idx += 1
                while k > 0:
                    res += substr
                    k -= 1
        return "".join(res)
    