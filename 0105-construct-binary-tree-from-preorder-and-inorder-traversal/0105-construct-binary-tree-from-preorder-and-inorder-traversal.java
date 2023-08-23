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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                break;
            } 
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = helper(
            Arrays.copyOfRange(preorder, 1, i + 1),
            Arrays.copyOfRange(inorder, 0,i)
        );
        root.right = helper(
            Arrays.copyOfRange(preorder, i + 1, preorder.length),
            Arrays.copyOfRange(inorder, i + 1, inorder.length)
        );
        return root;
    }
}