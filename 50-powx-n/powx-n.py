class Solution:
    def myPow(self, x: float, n: int) -> float:
        return self.helper(x, n)
    def helper(self, x, n):
        if n == 0:
            return 1
        if n < 0:
            return 1.0 / self.helper(x, -1*n)
        if n % 2 == 1:
            return x * self.helper(x * x, (n - 1) // 2)
        else:
            return self.helper(x * x, n // 2)
        



