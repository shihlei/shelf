## 863. All Nodes Distance K in Binary Tree

🔗 [Link](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/?envType=problem-list-v2&envId=7p5x763&sorting=W3sic29ydE9yZGVyIjoiREVTQ0VORElORyIsIm9yZGVyQnkiOiJGUkVRVUVOQ1kifV0%3D&page=1)

**📝 Topic: Tree, BFS, Queue**

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

**Example 1:**

> Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2  
Output: [7,4,1]  
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

```md
           3
        /     \
       5       1
      / \     / \
     6   2   0   8
        / \
       7   4
```

**Example 2:**

> Input: root = [1], target = 1, k = 3  
Output: []  

**Constraints:**

- The number of nodes in the tree is in the range [1, 500].
- 0 <= Node.val <= 500
- All the values Node.val are unique.
- target is the value of one of the nodes in the tree.
- 0 <= k <= 1000

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the tree be empty (null)? No, at least 1 node
3. Any requirement on time/space complexity? 

### Match
_See if this problem matches any data structures, algorithms_

- We should have a way in constant time O(1) to know each nodes parent -> hashTable / HashMap
- Then use a BFS with Queue(First in firt out) to find the nodes

📌 Concept to Remember!
- Queue -> make it BFS
- Stack, Call stack -> make it DFS

### Plan
_Walk through a implementation with an existing diagram_

1. Convert the tree into an undirected graph 
    - Every node is connected to both its parent and children
    - HashMap -> key will be all nodes. Value is the node can be reach from key node
2. BFS to Find Distance k Nodes
    - Init visited HashSet to record the node already visited
    - Init integer `currentLevel` to cound which level we are at
    - Start from target node at distance 0
    - At each queue level
        - Check if we've reached distance k, collect all nodes at this level. And return directly
        - Process all nodes at the current level with for loop
        - Traverse all the nodes in HashMap, and add unvisited neighbors to queue
    - Increase the `currentLevel`

Start from the target node. Traverse exactly k steps away and collect all nodes at that level
Create a visited set to track visited node.

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

Example Tree:
```md

Tree:        3
           /   \
          5     1
         / \   / \
        6   2 0   8
           / \
          7   4

target = 5
k = 2

Step 1: Build the Graph (Undirected)
After calling buildGraph(root, null, graph_map), the graph looks like:

graph_map = {
  3: [5, 1],           // 3 connects to 5 and 1
  5: [3, 6, 2],        // 5 connects to 3, 6, and 2
  1: [3, 0, 8],        // 1 connects to 3, 0, and 8
  6: [5],              // 6 connects to 5
  2: [5, 7, 4],        // 2 connects to 5, 7, and 4
  0: [1],              // 0 connects to 1
  8: [1],              // 8 connects to 1
  7: [2],              // 7 connects to 2
  4: [2]               // 4 connects to 2
}

Step 2: BFS Level by Level

▶️ Level 0 (currentLevel = 0)

queue = [5]
visited = {5}
levelSize = 1

currentLevel (0) != k (2), so continue...

Process node 5:
  - Neighbors: [3, 6, 2]
  - Add unvisited: 3, 6, 2
  
queue = [3, 6, 2]
visited = {5, 3, 6, 2}
currentLevel++ → 1

▶️ Level 1 (currentLevel = 1)

queue = [3, 6, 2]
visited = {5, 3, 6, 2}
levelSize = 3

currentLevel (1) != k (2), so continue...

Process node 3:
  - Neighbors: [5, 1]
  - 5 already visited ✗
  - Add unvisited: 1
  
Process node 6:
  - Neighbors: [5]
  - 5 already visited ✗
  
Process node 2:
  - Neighbors: [5, 7, 4]
  - 5 already visited ✗
  - Add unvisited: 7, 4

queue = [1, 7, 4]
visited = {5, 3, 6, 2, 1, 7, 4}
currentLevel++ → 2

▶️ Level 2 (currentLevel = 2)

queue = [1, 7, 4]
visited = {5, 3, 6, 2, 1, 7, 4}
levelSize = 3

currentLevel (2) == k (2) ✅

Collect all nodes in queue:
  - res.add(1.val) → res = [1]
  - res.add(7.val) → res = [1, 7]
  - res.add(4.val) → res = [1, 7, 4]

return [1, 7, 4]

```

### Evaluate

Time Complexity:  O(n) to build graph + O(n-1+n) for BFS -> O(n)

Why O(n-1+n)? Because for tree, the number of edges is always going to be 1 less than the number of nodes

Space Complexity: O(n) for graph + O(n) for queue -> O(n)
