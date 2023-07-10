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
        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }
        if (root.val == p.val || root.val == q.val) return root;
        // p.val < root < q.val
        if (p.val < root.val && root.val < q.val) return root;
        // p.val < q.val < root
        if (q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        // root < p.val < q.val
        if (root.val < p.val)
            return lowestCommonAncestor(root.right,p,q);
        return null;
    }
}