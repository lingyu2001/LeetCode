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
    double diff = Integer.MAX_VALUE;
    int val = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return val;
    }

    public void helper(TreeNode root, double target) {
        if (root == null) return ;
        if (Math.abs(root.val - target) == diff) {
            val = Math.min(val, root.val);
            diff = Math.abs(root.val - target);
        } else if (Math.abs(root.val - target) < diff) {
            val = root.val;
            diff = Math.abs(root.val - target);
        }
        helper(root.left, target);
        helper(root.right, target);
    }
}