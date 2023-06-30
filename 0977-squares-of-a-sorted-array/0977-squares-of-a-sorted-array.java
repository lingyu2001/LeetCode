class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1 ,k = nums.length - 1;
        int[] ret = new int[k + 1];
        while (k != -1) {
            // compare nums[i]^2 to nums[j]^2
            // if nums[i]^2 > nums[j]^2, then ret[k] = nums[i]^2; k--; i++;
            // else ret[k] = nums[j]^2; k--;j--;
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ret[k--] = nums[i] * nums[i];
                i++;
            } else {
                ret[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return ret;
    }
}