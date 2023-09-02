class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        helper(nums, 0);
        return res;
    }
    
    public void helper(int[] nums, int index) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            helper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}