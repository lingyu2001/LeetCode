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
    int index = 0;
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    public TreeNode helper(int[] nums, int left, int right) {
        if (left >= right) return null;
        int rootIndex = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, left, rootIndex);
        root.right = helper(nums, rootIndex + 1, right);
        return root;
    }
}