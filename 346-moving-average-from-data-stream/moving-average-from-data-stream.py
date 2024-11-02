class MovingAverage:

    def __init__(self, size: int):
        self.sz = size
        self.queue = deque()
        self.wsum = 0

    def next(self, val: int) -> float:
        self.queue.append(val)
        self.wsum += val
        if len(self.queue) > self.sz:
            self.wsum -= self.queue.popleft()
        return self.wsum / len(self.queue)
        


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)