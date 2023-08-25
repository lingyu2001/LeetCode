class Solution {
    public int maxSubArray(int[] nums) {
        // if (nums.length == 1) return nums[0];
        int start = 0, max = Integer.MIN_VALUE, sum = 0;
        for (; start < nums.length; start++) {
            sum += nums[start];
            max = Math.max(max, sum);
            // if all the numbers in nums are negative
            if (sum < 0) sum = 0;
        }
        return max;
    }
}