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
    int cnt = 1;
    int res = 0;
    int tgt;
    public int kthSmallest(TreeNode root, int k) {
        tgt = k;
        helper(root);
        return res;
    }

    public void helper (TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (cnt == tgt) {
            res = root.val;
        }
        cnt++;
        helper(root.right);
    }
}