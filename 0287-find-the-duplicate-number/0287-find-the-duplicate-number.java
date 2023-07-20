class Solution {
    public int findDuplicate(int[] nums) {
        int s = nums[0], f = nums[0];
        // find the intersection point
        while (true) {
            s = nums[s];
            f = nums[nums[f]];
            if (s == f) break;
        }
        int s1 = nums[0];
        while (s1 != s) {
            s1 = nums[s1];
            s = nums[s];
        }
        return s;
    }
}