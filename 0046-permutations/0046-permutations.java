class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        helper(nums,used);
        return res;
    }
    
    public void helper(int[] nums, boolean[] used) {
        if (path.size() >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        // k < n
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            helper(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }
}