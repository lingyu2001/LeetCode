class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        lo = min([interval[0] for interval in intervals])
        hi = max([interval[1] for interval in intervals])
        cnt = [0] * (hi + 2)
        for itv in intervals:
            cnt[itv[0]] += 1
            cnt[itv[1] + 1] -= 1
        cur_itv = 0
        max_itv = 0
        for i in range(lo, hi + 2):
            cur_itv += cnt[i]
            max_itv = max(max_itv, cur_itv)
        return max_itv



        