class Solution {
    public int[] twoSum(int[] nums, int target) {
        // iterate each number in nums
        // find target - num:
        // if it exists => return index 
        // else add this number to set. continue iterating the nums
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}