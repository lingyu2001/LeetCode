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
    public int maxDepth(TreeNode root) {
        return depth(root);
        
    }
    
    public int depth(TreeNode root) {
        int cnt = 0;
        if (root == null) return 0;
        cnt++;
        if (root.left == null && root.right == null) return cnt;
        else if (root.left != null && root.right == null) return cnt + depth(root.left);
        else if (root.right != null && root.left == null) return cnt + depth(root.right);
        else return cnt + Math.max(depth(root.left), depth(root.right));
    }
}