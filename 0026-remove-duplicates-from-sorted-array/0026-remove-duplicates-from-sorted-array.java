class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[j - 1]) {
                j++;
            } else{
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}