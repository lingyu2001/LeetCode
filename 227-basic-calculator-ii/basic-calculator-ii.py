class Solution:
    def calculate(self, s: str) -> int:
        s = s + "+"
        sign = "+"
        cur = 0
        prev = 0
        res = 0
        for c in s:
            # c is digit
            if c.isnumeric():
                # convert the digit to the total num
                cur = cur * 10 + int(c)
            else:
                if c != ' ':
                    if sign == "+":
                        res += prev
                        prev = cur
                    elif sign == "-":
                        res += prev
                        prev = -cur
                    elif sign == "*":
                        prev = prev * cur
                    elif sign == "/":
                        prev = math.trunc(prev/cur)
                    cur = 0
                    sign = c
        res += prev
        return res