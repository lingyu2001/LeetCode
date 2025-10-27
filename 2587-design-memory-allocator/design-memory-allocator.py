class Allocator:
    def __init__(self, n: int):
        # store free space
        self.free = [(0, n)]
        # store used space
        self.used = {}

    def allocate(self, size: int, mID: int) -> int:
        for idx,(l, r) in enumerate(self.free):
            length = r - l
            if length >= size:
                if length == size:
                    # update free space
                    self.free.pop(idx)
                else:
                    # there's some remainder space
                    # update free space
                    self.free[idx] = (l + size, r)
                # update used space
                self.used.setdefault(mID,[]).append((l, size))
                return l
        return -1

    def freeMemory(self, mID: int) ->int:
        blocked = self.used.pop(mID, [])
        ans = 0
        if not blocked:
            return ans
        for (start, size) in blocked:
            ans += size
            self._merge(start, size)
        return ans
    
    def _merge(self, start: int, size: int) -> None:
        # insert the blocks to free array, ensuring no overlapping
        end = start + size
        idx = bisect.bisect_left(self.free, (start, end)) # find the right place to insert
        # check overlapping with left interval
        if idx > 0 and self.free[idx - 1][1] == start:
            start = self.free[idx - 1][0]
            self.free.pop(idx - 1)
            idx -= 1
        # checking forward overlapping
        while idx < len(self.free) and self.free[idx][0] <= end:
            end = max(end, self.free[idx][1])
            self.free.pop(idx)
        self.free.insert(idx, (start, end))