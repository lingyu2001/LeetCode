class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt = Counter(nums)
        freq_list = [[v,k]for k,v in cnt.items()]
        freq_list.sort(reverse=True)
        return [k for v,k in freq_list[:k]]
