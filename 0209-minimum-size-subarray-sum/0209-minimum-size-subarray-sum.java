class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, result = Integer.MAX_VALUE, sum = 0;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min((right - left + 1), result);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}