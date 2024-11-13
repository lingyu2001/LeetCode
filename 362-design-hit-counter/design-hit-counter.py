class HitCounter:
    queue = None
    def __init__(self):
        self.queue = deque()
        self.total = 0

    def hit(self, timestamp: int) -> None:
        if not self.queue or self.queue[-1][1] != timestamp:
            self.queue.append([timestamp, 1])
        else:
            self.queue[-1][1] += 1
        self.total += 1

    def getHits(self, timestamp: int) -> int:
        while self.queue:
            diff = timestamp - self.queue[0][0]
            if diff >= 300:
                self.total -= self.queue.popleft()[1]
            else:
                break
        return self.total


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)