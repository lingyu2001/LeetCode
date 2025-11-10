import bisect
class TimeMap:

    def __init__(self):
        self.mapping = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.mapping:
            self.mapping[key] = []
        self.mapping[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.mapping:
            return ""
        arr = self.mapping[key]
        idx = bisect.bisect_right(arr, (timestamp, chr(255)))
        if idx - 1 < 0:
            return ""
        return arr[idx - 1][1]


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)