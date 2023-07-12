class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) cnt++;
        }
        if (cnt == 0) {
            if (k % 2 != 0) nums[0] = -nums[0];
        } else {
            // have negative values
            if (k <= cnt) {
                for (int i = 0; i < k; i++) {
                    nums[i] = -nums[i];
                }
            } else {
                for (int i = 0; i < cnt; i++) {
                    nums[i] = -nums[i];
                }
                if ((cnt - k) % 2 != 0) {
                    if (cnt >= nums.length) nums[cnt - 1] = -nums[cnt - 1];
                    else if (Math.abs(nums[cnt]) < Math.abs(nums[cnt - 1])) {
                        nums[cnt] = -nums[cnt];
                    } else {
                        nums[cnt - 1] = -nums[cnt - 1];
                    }
                    
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // System.out.print(nums[i]+" ");
            sum += nums[i];
        }
        return sum;
    }
}