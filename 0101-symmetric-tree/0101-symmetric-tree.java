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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        // terminated condition : if some node is null
        if (left == null && right == null) return true;
        else if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        // none of left node and right node is null
        if (left.val != right.val) return false;
        if (helper (left.left, right.right) && helper (left.right, right.left)) {
            return true;
        } 
        return false;
    }
}