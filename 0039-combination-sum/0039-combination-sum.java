class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,0, target);
        return res;
    }
    
    public void helper(int[] c,int index, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < c.length; i++) {
            path.add(c[i]);
            helper(c, i, target - c[i]);
            path.removeLast();
        }
    }
}