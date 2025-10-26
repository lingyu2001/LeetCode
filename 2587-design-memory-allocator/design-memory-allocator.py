class Allocator:

    def __init__(self, n: int):
        self.allocation = [None] * n
        self.size = n
        

    def allocate(self, size: int, mID: int) -> int:
        # if size > self.size:
        #     return -1
        # elif size == self.size:
        #     if len(self.allocation) == 0:
        #         return 0
        #     else:
        #         return -1
        left = 0
        while left < self.size:
            if self.allocation[left] != None:
                left += 1
            else:
                right = left
                while right < self.size and self.allocation[right] == None:
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