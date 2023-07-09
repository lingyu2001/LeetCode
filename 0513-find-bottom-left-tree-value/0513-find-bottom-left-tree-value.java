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
    int result = 0;
    int depth = 0, maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        if (root != null && root.left == null && root.right == null) return root.val;
        helper(root);
        return result;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        depth++;
        maxDepth = Math.max(depth, maxDepth);
        if (root.left != null) {
            if (depth == maxDepth)
                result = root.left.val;
            helper(root.left);
            depth--;
        }
        if (root.right != null) {
            if (depth == maxDepth && root.left == null)
                result = root.right.val;
            helper(root.right);
            depth--;
        }
    }
}