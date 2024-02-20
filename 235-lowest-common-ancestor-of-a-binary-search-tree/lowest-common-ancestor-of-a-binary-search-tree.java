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
        if (p != null && q != null) {
            if (p.val > q.val) {
                TreeNode t = p;
                p = q;
                q = t;
            }
        }
        if (root.val < q.val && root.val > p.val) {
            return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null) return left;
            else return right;
        }
    }
}