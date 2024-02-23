class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }

    public void helper(int[] c, int t, int idx) {
        if (t == 0) {
            res.add(new LinkedList<>(path));
        }
        // stop condition 
        if (idx >= c.length || t < 0) return;
        for (int i = idx; i < c.length; i++) {
            if (i > 0 && c[i - 1] == c[i] && !used[i - 1]) {
                continue;
            }
            path.add(c[i]);
                used[i] = true;
                helper(c, t - c[i], i + 1);
                path.removeLast();
                used[i] = false;
        }
    }
}