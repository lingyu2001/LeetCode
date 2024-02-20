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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int diameter = depth(root.left) + depth(root.right);
        System.out.println(diameter);
        max = Math.max(diameter, max);
        max = Math.max(diameterOfBinaryTree(root.left), max);
        max = Math.max(diameterOfBinaryTree(root.right), max);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}