class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, j = 0;
        if (nums.length == 1) return true;
        while (i <= j && i < nums.length) {
            j = Math.max(nums[i] + i, j);
            i++;
        }
        return j >= nums.length - 1;
    }
}