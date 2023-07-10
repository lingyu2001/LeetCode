/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode t1 = lowestCommonAncestor(root.left, p, q);
        TreeNode t2 = lowestCommonAncestor(root.right, p, q);
        if (t1 != null && t2 != null) return root;
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        else return t1;
    }
}