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
    List<String> list = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root);
        return list;
    }
    
    public void helper(TreeNode root) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            // turn path to string and add the string to list
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size()-1));
            list.add(sb.toString());
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left);
            path.removeLast();
        }
        if (root.right != null) {
            binaryTreePaths(root.right);
            path.removeLast();
        }
    }
}