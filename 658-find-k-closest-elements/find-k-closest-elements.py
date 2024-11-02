class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = bisect_left(arr, x) - 1
        right = left + 1
        # (), both exclusive
        while right - left - 1 < k:
            if left == -1:
                right += 1
                continue
            if right == len(arr) or x - arr[left] <= arr[right] - x:
                left -= 1
            else:
                right += 1
        return arr[left + 1: right]