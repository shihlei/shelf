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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        //BFS need queue 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            // List for each level
            List<Integer> onelevel = new ArrayList<>();
            int size = queue.size();

            //go through one level at a time
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

                // add child to the queue
                if(node != null){
                    onelevel.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            // add each level to result list
            // Will always have a empty list at the end, need to check onelevel not empty
            if(onelevel.size() != 0){
                result.add(onelevel);
            }
        }


        return result;
    }
}

/**
level order -> (BFS) algorithm to traverse the tree level by level. 

time: O(n)
space: O(n) queue can have up to O(n/2) nodes inside from the biggest level of a tree
 */