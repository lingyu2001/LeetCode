from bisect import bisect_left

class Allocator:
    def __init__(self, n: int):
        # free intervals as half-open [l, r), sorted and non-overlapping
        self.free = [(0, n)]
        # map mID -> list of (start, size)
        self.owned = {}

    def __repr__(self):
        return f"Allocator(free={self.free}, owned={self.owned})"

    def allocate(self, size: int, mID: int) -> int:
        if size <= 0:
            return -1
        for i, (l, r) in enumerate(self.free):
            length = r - l
            if length >= size:
                start = l
                new_l = l + size
                # replace interval with remainder (if any)
                if new_l == r:
                    self.free.pop(i)
                else:
                    self.free[i] = (new_l, r)
                self.owned.setdefault(mID, []).append((start, size))
                return start
        return -1

    def freeMemory(self, mID: int) -> int:
        blocks = self.owned.pop(mID, [])
        if not blocks:
            return 0

        # Insert each freed block and coalesce
        for start, size in blocks:
            self._insert_and_merge(start, start + size)
        return sum(size for _, size in blocks)

    # ---- helpers ----
    def _insert_and_merge(self, l: int, r: int) -> None:
        # find insertion position by start
        i = bisect_left(self.free, (l, r))
        # try to merge with left neighbor
        if i > 0 and self.free[i-1][1] >= l:
            i -= 1
            l = self.free[i][0]
            r = max(r, self.free[i][1])
            self.free.pop(i)
        # merge forward while overlapping / touching
        while i < len(self.free) and self.free[i][0] <= r:
            l = min(l, self.free[i][0])
            r = max(r, self.free[i][1])
            self.free.pop(i)
        # insert merged interval
        self.free.insert(i, (l, r))
