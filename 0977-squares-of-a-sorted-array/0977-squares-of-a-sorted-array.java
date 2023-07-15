class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int resIndex = res.length - 1;
        while (left <= right) {
            int leftS = nums[left] * nums[left];
            int rightS = nums[right] * nums[right];
            if (leftS <= rightS) {
                res[resIndex--] = rightS;
                right--;
            } else {
                res[resIndex--] = leftS;
                left++;
            }
        }
        return res;
    }
}