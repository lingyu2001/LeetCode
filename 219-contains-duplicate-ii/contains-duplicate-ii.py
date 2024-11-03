class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        table = defaultdict(int)
        for i in range(len(nums)):
            if nums[i] in table:
                if abs(i - table[nums[i]]) <= k:
                    return True
            table[nums[i]] = i
        return False
            