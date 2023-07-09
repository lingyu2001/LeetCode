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
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);
        return res;
    }
    public void helper(TreeNode root, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            System.out.println(path.toString());
            // path.removeLast();
            return;
        }
        helper(root.left, targetSum);
        if (root.left != null) {
            path.removeLast();
            sum -= root.left.val;
        }
        helper(root.right, targetSum);
        if (root.right != null) { 
            path.removeLast();
            sum -= root.right.val;
        }
    }
}