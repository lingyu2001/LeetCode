class Solution:
    def calculate(self, s: str) -> int:
        sign = "+"
        s += '+'
        sign = "+"
        res = 0
        num = 0
        stack = []
        for c in s:
            if c.isnumeric():
                num = num * 10 + int(c)
            elif c != ' ':
                if sign == '*':
                    stack.append(stack.pop() * num)
                elif sign == '/':
                    stack.append(math.trunc(stack.pop() / num))
                elif sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                num = 0
                sign = c
        for n in stack:
            res += n
        return res