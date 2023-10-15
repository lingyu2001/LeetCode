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
    public void flatten(TreeNode root) {
        root = helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        TreeNode p = left;
        root.left = null;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (p != null) p.right = right;
        if (left != null) root.right = left;
        return root;
    }
}