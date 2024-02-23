class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int idx) {
        // stop recursion
        res.add(new LinkedList<>(path));
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;
            used[i] = true;
            path.add(nums[i]);
            helper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}