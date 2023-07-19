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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return cnt;
    }
    public void helper(TreeNode root, int max) {
        if (root == null) return;
        int max1 = max;
        if (root.val >= max1) {
            cnt++;
            max1 = root.val;
        }
        helper(root.left,max1);      
        helper(root.right,max1);
    }
}