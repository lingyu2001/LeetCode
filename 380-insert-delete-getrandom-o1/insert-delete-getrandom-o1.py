class RandomizedSet:

    def __init__(self):
        self.list = []
        self.dict = {} # val:idx

    def insert(self, val: int) -> bool:
        if val not in self.dict:
            self.dict[val] = len(self.list)
            self.list.append(val)
            return True
        else:
            return False

    def remove(self, val: int) -> bool:
        if val not in self.dict:
            return False
        last_val, idx = self.list[-1], self.dict[val]
        self.list[idx] = last_val
        self.dict[last_val] = idx
        self.list.pop()
        del self.dict[val]
        return True


    def getRandom(self) -> int:
        return choice(self.list)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()