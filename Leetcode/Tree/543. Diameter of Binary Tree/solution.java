public class solution {
    
}
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
    public int diameterOfBinaryTree(TreeNode root) {
        // need an array that are passed by reference
        int[] result = new int[1];
        dfsHeight(root, result);
        return result[0];
    }

    // compute and return the height
    private int dfsHeight(TreeNode root, int[] res) {
        if (root == null){
            return 0;
        }

        // Recursively get left and right height
        int leftHeight = dfsHeight(root.left, res);
        int rightHeight = dfsHeight(root.right, res);

        // Update the global answer with this diameter
        res[0] = Math.max(res[0], leftHeight + rightHeight);

        //return height (remember to add 1 for the path connecting the node and its parent)
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
