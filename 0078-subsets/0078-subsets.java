class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0,nums.length);
        return res;
    }
    
    public void helper(int[] nums, int i, int j) {
        if (i >= j) {
            res.add(new ArrayList<>(path));
            return ;
        }
        path.add(nums[i]);
        helper(nums,i + 1,nums.length);
        path.removeLast();
        helper(nums, i + 1, nums.length);
        return;
    }
}