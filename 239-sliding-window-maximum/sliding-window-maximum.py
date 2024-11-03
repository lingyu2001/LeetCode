class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # deque: store the indices of elems in num, maining the value in a decreasing order
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
            if i - k == dq[0]:
                dq.popleft()
            # is the current val the largest
            while dq and nums[i] >= nums[dq[-1]]:
                dq.pop()
            dq.append(i)
            res.append(nums[dq[0]])
        return res