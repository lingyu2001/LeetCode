class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        int prevDiff = 0, currDiff = 0, result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            if ((prevDiff >= 0 && currDiff < 0) || (prevDiff <= 0 && currDiff > 0)) {
                result++;
                prevDiff = currDiff;
            }
        }
        return result;
    }
}