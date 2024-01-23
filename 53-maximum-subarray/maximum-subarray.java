class Solution {
    public int maxSubArray(int[] nums) {
        // sliding window
        // sum of the window , compare the sum to max res
        // sum >= 0 move right
        // <0 , move left until sum >= 0 or left > ri
        // ri++;
        int res = Integer.MIN_VALUE;
        int lo = 0, ri = 0;
        int sum = 0;
        while (ri < nums.length) {
            sum += nums[ri];
            res = Math.max(res, sum);
            if (sum >= 0) {
                ri++;
            } else {
                while (lo <= ri && sum < 0) {
                    sum -= nums[lo];
                    lo++;
                }
                ri++;
            }
        }
        return res;
    }
}