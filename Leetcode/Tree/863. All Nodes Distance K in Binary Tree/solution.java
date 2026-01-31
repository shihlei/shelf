/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // k = 0 -> reture target node
        if (k == 0) {
            return Arrays.asList(target.val);
        }

        // Convert tree to undirected graph
        HashMap<TreeNode, List<TreeNode>> graph_map = new HashMap<>();
        buildGraph(root, null, graph_map);

        // BFS to find nodes at distance k
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // Start from target node at distance 0
        queue.add(target);
        visited.add(target);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // If we've reached distance k, collect all nodes at this level
            if (currentLevel == k) {
                for (int i = 0; i < levelSize; i++) {
                    res.add(queue.poll().val);
                }
                return res;
            }

            // Process all nodes at the current level
            for(int i =0 ; i < levelSize ; i++){
                TreeNode node = queue.poll();

                // Add unvisited neighbors to queue
                for (TreeNode neighbor : graph_map.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }

            currentLevel++; // Move to the next level
        }

        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph_map) {
        if (node == null) return;

        // Initialize adjacency list for this node
        graph_map.putIfAbsent(node, new ArrayList<>());

        // If there's a parent, create a two-way connection
        if (parent != null) {
            graph_map.get(node).add(parent);
            graph_map.get(parent).add(node);
        }

        // Recursively process left and right children
        buildGraph(node.left, node, graph_map);
        buildGraph(node.right, node, graph_map);
    }
}

/**
We should have a way in constant time O(1) to know each nodes parent -> hashTable / Hashmap
Then use a queue(First in firt out) and BFS to find the nodes

1. Convert the tree into an undirected graph 
-> every node is connected to both its parent and children
HashMap -> key will be all nodes. Value is the node can be reach from key node

2. BFS to Find Distance k Nodes
Start from the target node. Traverse exactly k steps away and collect all nodes at that level
Create a visited set to track visited node.

time: O(n) + O(n) -> O(n)to build graph and BFS
space: O(n) graph + O(n) queue -> O(n)
 */
