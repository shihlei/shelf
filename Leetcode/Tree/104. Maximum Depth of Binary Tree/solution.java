class Solution {
    public int maxDepth(TreeNode root) {
        // base case
        if(root == null){
            return 0;
        }

        // pass the count -> Resursive both left and right node
       return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}