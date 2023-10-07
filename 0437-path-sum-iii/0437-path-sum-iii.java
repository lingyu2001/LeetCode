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
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);
        return dfs(root, targetSum, 0L);
    }

    public int dfs(TreeNode root, int targetSum, Long currSum) {
        if (root == null) return 0;
        currSum += root.val;
        int res = map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        res += dfs(root.left, targetSum, currSum) + dfs(root.right, targetSum, currSum);
        map.put(currSum, map.get(currSum) - 1);
        return res;
    }
}