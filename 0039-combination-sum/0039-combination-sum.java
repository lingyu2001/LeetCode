class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }

    public void helper(int[] c, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return ;
        }
        if (target < 0) return;
        for (int i = index; i < c.length; i++) {
            path.add(c[i]);
            helper(c, target - c[i], i);
            path.removeLast();
        }
    }
}