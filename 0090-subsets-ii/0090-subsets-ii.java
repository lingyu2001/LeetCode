class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0);
        return res;
    }
    
    public void helper(int[] nums, int k) {
        res.add(new ArrayList<>(path));
        // k <= n
        for (int i = k; i < nums.length; i++) {
            if (i > k && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            helper(nums, i + 1);
            path.removeLast();
        }
    }
}