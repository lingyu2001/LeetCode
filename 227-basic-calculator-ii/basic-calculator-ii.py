class Solution:
    def calculate(self, s: str) -> int:
        s = s+'+'
        sign = '+'
        res = 0
        last_num = 0
        num = 0
        for c in s:
            if c.isnumeric():
                num = num * 10 + int(c)
            elif c != ' ':
                if sign == '*':
                    last_num = last_num * num
                elif sign == '/':
                    last_num = math.trunc(last_num / num)
                elif sign == '+':
                    res += last_num
                    last_num = num
                elif sign == '-':
                    res += last_num
                    last_num = -num
                sign = c
                num = 0
        res += last_num
        return res