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
        return helper(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    
    public TreeNode helper(int[] preorder,int prebegin, int preend, int[] inorder, int inbegin, int inend) {
        if (inbegin == inend) return null;
        TreeNode root = new TreeNode(preorder[prebegin]);
        //leaf
        if (preend - prebegin == 1) return root;
        
        int i = 0;
        for (i = inbegin; i < inend; i++) {
            if (inorder[i] == root.val) break;
        }
        
        int inLeftBegin = inbegin;
        int inLeftEnd = i;
        int preLeftBegin = prebegin + 1;
        int preLeftEnd = preLeftBegin + (inLeftEnd - inLeftBegin);
        
        int inRightBegin = i + 1;
        int inRightEnd = inend;
        int preRightBegin = preLeftEnd;
        int preRightEnd = preend;
        
        root.left = helper(preorder, preLeftBegin, preLeftEnd,inorder,inLeftBegin, inLeftEnd);
        root.right = helper(preorder, preRightBegin,preRightEnd, inorder, inRightBegin,inRightEnd);
        return root;
    }
}
    