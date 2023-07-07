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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                swap(t);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return root;
    }
    
    public void swap(TreeNode root) {
        if (root == null) return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}