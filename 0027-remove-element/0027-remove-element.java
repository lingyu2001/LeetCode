class Solution {
    public int removeElement(int[] nums, int val) {
        int s = 0, f = 0;
        while (f < nums.length) {
            if (nums[f] == val) {
                f++;
            } else {
                nums[s] = nums[f];
                f++;
                s++;
            }
        }
        return s;
    }
}