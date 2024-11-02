class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        self.cnt = Counter(nums)
        return self.quick_select(list(self.cnt.keys()), len(self.cnt.keys()) - k)

    def quick_select(self, nums, k):
        left = 0
        right = len(nums) - 1
        pivot_idx = len(nums)
        while pivot_idx != k:
            pivot_idx = self.partition(nums, left, right)
            if pivot_idx > k:
                right = pivot_idx - 1
            else:
                left = pivot_idx
        return nums[k:]

    def partition(self, nums, left, right):
        pivot_idx = random.randint(left, right)
        pivot_val = self.cnt[nums[pivot_idx]]
        while left < right:
            if self.cnt[nums[left]] < pivot_val:
                left += 1
            else:
                nums[left], nums[right] = nums[right], nums[left]
                right -= 1
        if self.cnt[nums[left]] < pivot_val:
            left += 1
        return left

    


        