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
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                size--;
                TreeNode t = queue.poll();
                path.add(t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
            res.add(new ArrayList(path));
            path.clear();
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ret.add(res.get(i));
        }
        return ret;
    }
}