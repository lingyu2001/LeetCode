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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        // if left child is not null, add the value of the left child to sum
        // recursively run sumofleftleaves on left child tree 
        // do the same thing on right child tree
        if (root.left != null) {
            TreeNode left = root.left;
            if(left.left == null && left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(left);
            }
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}