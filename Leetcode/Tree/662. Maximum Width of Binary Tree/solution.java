class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1)); // Start root with index 1

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int leftMost = 0;
            int rightMost = 0;

            // Process all nodes at current level
            for(int i = 0 ; i < levelSize ; i++){
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                int index = current.getValue();

                // Track leftMost and rightMost indices
                if(i==0) leftMost = index;
                if(i == levelSize - 1) rightMost = index;

                // Add children with their calculated indices
                if(node.left != null){
                    queue.offer(new Pair<>(node.left, index * 2));
                }

                if(node.right != null){
                    queue.offer(new Pair<>(node.right, index * 2 + 1));
                }
            }

            // Calculate width of current level
            res = Math.max(res, rightMost - leftMost + 1);
        }

        return res;
    }
}
