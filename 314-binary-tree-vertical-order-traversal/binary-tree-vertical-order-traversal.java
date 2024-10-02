/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        helper(root);
        int[] keys = new int[map.keySet().size()];
        int idx = 0;
        for (int key : map.keySet()) {
            keys[idx++] = key;
        }
        Arrays.sort(keys);
        for (int key : keys) {
            res.add(map.get(key));
        }
        return res;
    }

    public void helper(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair(root, 0));
        }
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int n = p.getValue();
            List<Integer> list = map.getOrDefault(n, new LinkedList<Integer>());
            list.add(node.val);
            map.put(n, list);
            if (node.left != null) {
                queue.add(new Pair(node.left, n - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, n + 1));
            }
        }
    }
}