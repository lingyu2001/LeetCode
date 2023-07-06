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
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode t = new TreeNode(-101);
            while (size != 0) {
                size--;
                t = queue.poll();
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
            if (t.val != -101) res.add(t.val);
        }
        return res;
    }
}