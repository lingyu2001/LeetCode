class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }
    
    public void helper(int[] c, int target, int index) {
        if (target < 0) return ;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < c.length; i++) {
            if (i > index && c[i] == c[i - 1]) continue;
            path.add(c[i]);
            helper(c, target - c[i], i + 1);
            path.removeLast();
        }
    }
}