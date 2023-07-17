class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        int cnt = 1, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                cnt++;
            } else {
                prev = nums[i];
                cnt = 1;
            }
            if (cnt > nums.length / 2) return nums[i];
        }
        return 0;
    }
}