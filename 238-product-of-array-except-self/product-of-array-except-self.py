class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        pre_product = [0] * (len(nums))
        pre_product[0] = 1
        for i in range(1, len(nums)):
            pre_product[i] = pre_product[i - 1] * nums[i - 1]
        post_product = 1
        for i in range(len(nums) - 1, -1, -1):
            pre_product[i] *= post_product
            post_product *= nums[i]
        return pre_product