class HitCounter:
    def __init__(self):
        self.hits = []

    def hit(self, timestamp: int) -> None:
        self.hits.append(timestamp)

    def getHits(self, timestamp: int) -> int:
        left, right = 0, len(self.hits)
        target = timestamp - 300
        while left < right:
            mid = (left + right) // 2

            if self.hits[mid] <= target:
                left = mid + 1
            else:
                right = mid
        
        return len(self.hits) - left