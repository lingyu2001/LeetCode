class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res1 = new int[nums.length];
        int[] res2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i == 0) res1[0] = 1;
            else {
                res1[i] = res1[i - 1] * nums[i - 1];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) res2[i] = 1;
            else {
                res2[i] = res2[i + 1] * nums[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res1[i] = res1[i] * res2[i];
        }
        return res1;
    }
}