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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            // case2: 
            if (root.left == null && root.right == null) return null;
            // case 3:
            else if (root.left == null) {
                root = root.right;
                return root;
            }
            // case 4:
            else if (root.right == null) {
                root = root.left;
                return root;
            } else {
            // case 5:
                TreeNode cur = root.right;
                while (cur.left != null)
                    cur = cur.left;
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}