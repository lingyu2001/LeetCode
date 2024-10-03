class Solution(object):
    map = {}
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        self.map[0] = 1
        self.map[1] = x
        self.helper(x, abs(n))
        if n >= 0:
            return self.map[n]
        else:
            return 1 / self.map[-n]
    def helper(self, x, n):
        if n == 0 or n == 1:
            return
        if n % 2 == 0:
            self.helper(x, n / 2)
            self.map[n] = self.map[n/2] * self.map[n/2]
        else:
            self.helper(x, (n-1)/2)
            self.map[n - 1] = self.map[(n-1)/2] * self.map[(n-1)/2]
            self.map[n] = x * self.map[n - 1]
            
        