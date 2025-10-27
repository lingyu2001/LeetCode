class Allocator:

    def __init__(self, n: int):
        # store free storage
        self.free = [(0, n)]
        # store used storage, mID:(start index, size)
        self.owned = {} 

    def allocate(self, size: int, mID: int) -> int:
        # first-fit
        # iterate all free storage and find the first storage that fits
        for idx, (l, r) in enumerate(self.free):
            length = r - l 
            # compare 
            if length >= size:
                # fits
                # update free storage 
                if l + size == r:
                    self.free.pop(idx)
                else:
                    self.free[idx] = (l + size,r)
                self.owned.setdefault(mID, []).append((l, size))
                return l
        return -1

    def freeMemory(self, mID: int) ->int:
        # put the free memory back to the free array
        # merge
        blocked = self.owned.pop(mID, [])
        if not blocked:
            return 0
        ans = 0
        for l, s in blocked:
            ans += s
            self._merge(l, s)
        return ans
    
    def _merge(self, start: int, size: int) -> None:
        # binary insert
        idx = bisect.bisect_left(self.free, (start, start + size))
        # try merging the left block
        l = start
        r = start + size
        if idx > 0 and self.free[idx - 1][1] == start:
            l = self.free[idx-1][0]
            idx = idx - 1
            r = max(self.free[idx][1], r)
            self.free.pop(idx)
        # check the forward overlapping
        while idx < len(self.free) and self.free[idx][0] <= r:
            r = max(self.free[idx][1], r)
            self.free.pop(idx)
        self.free.insert(idx, (l, r))
