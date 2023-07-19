class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        long sum = 0;
        int max = 0;
        while (r < nums.length) {
            sum += nums[r];
            int len = r - l + 1;
            // System.out.println(r+" "+l + " " + sum);
            if ((long)(nums[r] * len) <= (sum + k)) {
                max = Math.max(max, len);
                // if (len == 5)
            } else if (nums[r] * len > sum + k) {
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return max;
    }
}