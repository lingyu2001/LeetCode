# 注意：python 代码由 chatGPT\U0001f916 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 取两端都闭的二分搜索
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        # 因为题目必然有解，所以设置 left == right 为结束条件
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[mid + 1]:
                # mid 本身就是峰值或其左侧有一个峰值
                right = mid
            else:
                # mid 右侧有一个峰值
                left = mid + 1
        return left