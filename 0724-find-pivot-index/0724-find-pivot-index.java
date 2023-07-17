class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            if (i - 1 >= 0) leftSum += nums[i - 1];
            if(leftSum == rightSum) return i;
        }
        return -1;
    }
}