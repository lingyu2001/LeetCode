class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            max = Math.max(max, sum + i);
            if (sum + i < 0) {
                sum = 0;
            } else sum += i;
        }
        return max;
    }
}