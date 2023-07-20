class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0,nums.length);
        return res;
    }
    
    public void helper(int[] nums, int i, int j) {
        res.add(new ArrayList<>(path));
        if (i >= j) {
            return ;
        }
        for (int k = i; k < j; k++) {
            path.add(nums[k]);
            helper(nums,k + 1,nums.length);
            path.removeLast();
        }
        return;
    }
}