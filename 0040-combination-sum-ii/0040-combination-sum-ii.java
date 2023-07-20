class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target);
        return res;
    }
    
    public void helper(int[] c, int k, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = k; i < c.length; i++) {
            if (i > k && c[i] == c[i - 1]) continue;
            path.add(c[i]);
            helper(c, i + 1, target - c[i]);
            path.removeLast();
        }
    }
}