class Allocator:

    def __init__(self, n: int):
        self.allocation = [None] * n
        self.size = n
        

    def allocate(self, size: int, mID: int) -> int:
        left = 0
        while left < self.size:
            if self.allocation[left] is not None:
                left += 1
            else:
                right = left
                while right < self.size and self.allocation[right] is None:
                    free_size = right - left + 1
                    if free_size >= size:
                        self.allocation[left:left + size] =  [mID] * size
                        return left
                    else:
                        right += 1
                left = right + 1
        return -1

    def freeMemory(self, mID: int) -> int:
        cnt = 0
        for idx in range(0, self.size):
            if self.allocation[idx] == mID:
                self.allocation[idx] = None
                cnt += 1
        return cnt