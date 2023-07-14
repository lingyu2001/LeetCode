class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> generate(int numRows) {
        helper(numRows);
        return res;
    }
    
    public void helper(int n) {
        for (int level = 0; level < n; level++) {
            path.add(1);
            for (int i = 1; i <= level - 1; i++) {
                List<Integer> lastArray = res.get(level - 1);
                path.add(lastArray.get(i) + lastArray.get(i - 1));
            }
            if (level != 0) path.add(1);
            res.add(new ArrayList<>(path));
            path.clear();
        }
    }
}