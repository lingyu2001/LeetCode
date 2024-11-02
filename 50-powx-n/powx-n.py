class Solution:
    def myPow(self, x: float, n: int) -> float:
        return self.helper(x ,n)

    def helper(self, x, n):
        if n == 0:
            return 1
        if n < 0:
            n = -n
            x = 1/x
        res = 1
        while n != 0:
            if n % 2 == 1:
                res = x * res
                n -= 1
            x = x * x
            n //= 2
        return res