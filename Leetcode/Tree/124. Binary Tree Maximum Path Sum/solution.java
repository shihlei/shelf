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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumDFS(root);
        return maxSum;
    }

    // return max path sum without split
    private int maxPathSumDFS(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = maxPathSumDFS(root.left);
        int rightMax = maxPathSumDFS(root.right);

        // prevent 
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // Maximum path sum passing through current node
        int pathThroughCurrent = root.val + leftMax + rightMax;

        // compute max path sum with split
        maxSum = Math.max(maxSum, pathThroughCurrent);

        //We return the maximum path sum from the current node to its parent,
        // considering only one of the subtrees (either left or right) to extend the path. 
        return root.val + Math.max(leftMax, rightMax);
    }
}
