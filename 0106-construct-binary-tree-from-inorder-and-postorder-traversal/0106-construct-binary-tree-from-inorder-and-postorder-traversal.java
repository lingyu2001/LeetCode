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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length, postorder,0, postorder.length);
    }
    
    public TreeNode helper (int[] inorder, int inBegin, int inEnd, int[] postorder, int posBegin, int posEnd) {
        if (inBegin == inEnd) return null;
        // root 
        TreeNode root = new TreeNode(postorder[posEnd - 1]);
        // leaf node
        if (posEnd - posBegin == 1) return root;
        // inorder left
        int splitIndex = 0;
        for (splitIndex = inBegin; splitIndex < inEnd; splitIndex++) {
            if (inorder[splitIndex] == root.val) break;
        }
        // inorder left : [0,splitIndex)
        // inorder right : [spliyIndex + 1, inorder.length)
        // postorder left : [0,splitIndex)
        // postorder right :[spliyIndex, inorder.length - 1)
        
        root.left = helper(inorder, inBegin, splitIndex, postorder, posBegin, posBegin + splitIndex - inBegin);
        root.right = helper(inorder, splitIndex + 1, inEnd, postorder,posBegin + splitIndex - inBegin , posEnd - 1);
        return root;
    }
}