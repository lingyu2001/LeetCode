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
    int res = 0;
    int cnt = 0;
    int kk = 0;
    public int kthSmallest(TreeNode root, int k) {
        kk = k;
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return ;
        helper(root.left);
        if (cnt + 1 == kk) {
            res = root.val;
            
        } 
        cnt++;
        helper(root.right);
    }
}