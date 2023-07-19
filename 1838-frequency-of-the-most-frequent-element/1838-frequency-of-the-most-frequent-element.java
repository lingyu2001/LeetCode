class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        long sum = 0, max = 0;
        while (r < nums.length) {
            sum += nums[r];
            // System.out.println(r+" "+l + " " + sum);
            while (l < nums.length && (long)(nums[r] * (r-l+1)) > (long)(sum + k)) {
                sum -= nums[l];
                l++;
            }
            max = Math.max(max, (r-l+1));
            r++;
        }
        return (int)max;
    }
}


