class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == target - nums[i]) return new int[]{j, i};
                }
            } else {
                set.add(nums[i]);
            }
        }
        return null;
    }
}