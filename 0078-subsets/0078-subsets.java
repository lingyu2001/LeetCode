class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0);
        return res;
    }
    
     public void helper(int[] nums, int index) {
         res.add(new ArrayList<>(path));
         for (int i = index ; i < nums.length; i++) {
             path.add(nums[i]);
             helper(nums, i + 1);
             path.removeLast();
         }
     }
}