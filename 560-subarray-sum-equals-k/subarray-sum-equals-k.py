class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        total = 0
        cnt = defaultdict(int)
        cnt[0] = 1
        for i in nums:
            total += i
            if total - k in cnt:
                res += cnt[total - k]
            cnt[total] += 1
        return res
