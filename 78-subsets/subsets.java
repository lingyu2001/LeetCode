class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int index) {
        res.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i+ 1);
            path.removeLast();
        }
    }
}