class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        n1 = list(num1)
        n2 = list(num2)
        res = []
        digits = 0
        i = 1
        while i <= (max(len(n1), len(n2))):
            if i > len(n1):
                a = 0
            else:
                a = int(n1[-i])
            if i > len(n2):
                b = 0
            else:
                b = int(n2[-i])
            # print(a,b)
            add = (a + b + digits) % 10
            digits = (a + b + digits) // 10
            res = [add] + res
            # print(res)
            i += 1
        if digits != 0:
            res = [digits] + res
            i += 1
        ret = ""
        for i in res:
            ret = ret + str(i)
        return ret