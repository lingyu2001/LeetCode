class Solution {
    int tgt;
    HashMap<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        tgt = target;
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int index, int total) {
        if (index == nums.length) {
            return total == tgt ? 1 : 0;
        }
        String s = index + "," + total;
        if (map.containsKey(s)) return map.get(s);
        int res = helper(nums, index + 1, total + nums[index]) + helper(nums, index + 1, total - nums[index]);
        map.put(s, res);
        return res;
    }
}