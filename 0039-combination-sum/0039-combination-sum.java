class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0);
        return res;
    }
    
    public void helper(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            // System.out.println("1");
            return ;
        } else if (target < 0) return;
        for (int i = index; i < candidates.length;i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i);
            // System.out.println("1");
            path.removeLast();
        }
    }
}