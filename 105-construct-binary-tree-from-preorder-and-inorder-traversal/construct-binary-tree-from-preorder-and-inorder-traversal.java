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
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        // edge case: the tree not exists
        if (preStart > preEnd) return null;
        // find the root
        TreeNode root = new TreeNode(preorder[preStart]);
        // find the root in the inorder array 
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        // the size of left child tree
        int sizeOfLeft = i - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + sizeOfLeft, inStart, i - 1);
        // right child tree?
        root.right = helper(preorder, inorder, preStart + sizeOfLeft + 1, preEnd, i + 1, inEnd);
        return root;
    }
}