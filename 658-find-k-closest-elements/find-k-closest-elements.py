class Solution:
    def findClosestElements1(self, arr: List[int], k: int, x: int) -> List[int]:
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
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Initialize binary search bounds
        left = 0
        right = len(arr) - k #the farthest starting position for a subarray of size k within arr
        
        # Binary search against the criteria described
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid

        return arr[left:left + k]