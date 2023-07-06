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
    List<Double> res = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            int i = 0;
            while (i < size) {
                i++;
                TreeNode t = q.poll();
                sum += t.val;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(sum / size);
        }
        return res;
    }
}