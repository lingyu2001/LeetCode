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
    int max = -1;
    int indexMax = -1;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // if the array is null return null
        // find the index of maxmium value
        // create a root node with the max value
        // if the array has only one node, return root
        
        // recursively build the left child and right child
        return helper(nums,0,nums.length);
    }
    
    public TreeNode helper(int[] nums, int start, int end) {
        if (start == end) return null;
        if (end - start == 1) return new TreeNode(nums[start]);
        int index = 0,  max = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        if (end - start == 1) return root;
        root.left = helper(nums, start, index);
        root.right = helper(nums, index + 1, end);
        return root;
    }
}