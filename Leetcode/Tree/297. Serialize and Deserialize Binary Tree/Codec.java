/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();  
        dfsSerialize(root, res);
        return String.join(",", res);  
    }

    // pre-order dfs
    private void dfsSerialize(TreeNode node, List<String> res){
        if(node == null){
            res.add("N");
            return;
        }

        // convert int to string
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // split based on comma
        String[] vals = data.split(",");
        int[] i ={0};
        return dfsDeserialize(vals, i);
    }

    private TreeNode dfsDeserialize(String[] vals, int[] i){
        // if is "N"
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        // create node (convert string to int)
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;

        node.left = dfsDeserialize(vals, i);
        node.right =  dfsDeserialize(vals, i);

        return node;
    }
}

// BFS to serialize level by level
// DFS preorder treversal


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));