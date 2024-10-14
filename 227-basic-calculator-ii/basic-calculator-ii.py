class Solution:
    def calculate(self, s: str) -> int:
        s += '+'
        sign = '+'
        res = 0
        num = 0
        last_num = 0
        for c in s:
            if c.isnumeric():
                num = num * 10 + int(c)
            elif c != ' ':
                if sign == '*':
                    last_num = num * last_num
                elif sign == '/':
                    last_num = math.trunc(last_num/num)
                elif sign == '+':
                    res += last_num
                    last_num = num
                elif sign == '-':
                    res += last_num
                    last_num = -num
                num = 0
                sign = c
        res += last_num
        return res