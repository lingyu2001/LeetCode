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
    int[] pre;
    int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        TreeNode root = helper(0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public TreeNode helper(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart >= pre.length || inStart >= in.length || preEnd < preStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) break;
        }
        int leftSize = i - inStart;
        TreeNode left = helper(preStart + 1, preStart + leftSize, inStart, i - 1);
        TreeNode right = helper(preStart + 1 + leftSize, preEnd, i + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}