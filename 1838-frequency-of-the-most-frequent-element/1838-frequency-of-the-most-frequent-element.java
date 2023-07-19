class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        long sum = 0, max = 0;
        while (r < nums.length) {
            sum += nums[r];
            // System.out.println(r+" "+l + " " + sum);
            while (sum + k < (long)nums[r] * (r - l + 1)) {
                sum -= nums[l];
                l++;
            }
            max = Math.max(max, (r-l+1));
            r++;
        }
        return (int)max;
    }
}


    // public int maxFrequency(int[] A, int k) {
    //     int res = 1, i = 0, j;
    //     long sum = 0;
    //     Arrays.sort(A);
    //     for (j = 0; j < A.length; ++j) {
    //         sum += A[j];
    //         while (sum + k < (long)A[j] * (j - i + 1)) {
    //             sum -= A[i];
    //             i += 1;
    //         }
    //         res = Math.max(res, j - i + 1);
    //     }
    //     return res;
    // }