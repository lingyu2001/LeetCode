class Solution(object):
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.n_to_idx = defaultdict(list)
        for i, n in enumerate(nums):
            self.n_to_idx[n].append(i)


    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        idx_arr = self.n_to_idx[target]
        return idx_arr[random.randint(0, len(idx_arr) - 1)]

        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)