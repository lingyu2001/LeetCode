class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # The deque (dq) is used to store indices of elements in nums, 
        # maintaining a decreasing order of values from front to back.
        # This ensures that the largest element in the current window is always at the front of the deque (dq[0]).
        dq = deque()
        res = []
        # first window
        for i in range(k):
            while dq and nums[i] >= nums[dq[-1]]:
                dq.pop()
            dq.append(i)
        res.append(nums[dq[0]])
        # remaining window
        for i in range(k, len(nums)):
            if dq and i - k == dq[0]:
                dq.popleft()
            while dq and nums[i] >= nums[dq[-1]]:
                dq.pop()
            dq.append(i)
            res.append(nums[dq[0]])

        return res