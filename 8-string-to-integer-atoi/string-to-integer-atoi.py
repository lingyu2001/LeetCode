class Solution:
    def myAtoi(self, s: str) -> int:
        n = len(s)
        i = 0
        res = 0
        INT_MIN = - (pow(2, 31))
        INT_MAX = pow(2,31) - 1
        sign = 1
        # remove space
        while i < n and s[i] == ' ':
            i += 1
        # detect sign
        if i < n and s[i] == "+":
            sign = 1
            i += 1
        elif i < n and s[i] == "-":
            sign = -1
            i += 1
        while i < n and s[i].isdigit():
            d = int(s[i])
            # overflow
            if res > INT_MAX // 10 or (res == INT_MAX // 10 and d > INT_MAX % 10):
                return INT_MAX if sign == 1 else INT_MIN
            res = res * 10 + d
            i += 1
        return res if sign == 1 else -res
        