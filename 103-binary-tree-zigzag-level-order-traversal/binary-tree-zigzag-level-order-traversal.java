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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        int round = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            LinkedList<Integer> arr = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                arr.add(t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
            if (round % 2 == 1) Collections.reverse(arr);
            round++;
            res.add(arr);
        }
        return res;
    }
}