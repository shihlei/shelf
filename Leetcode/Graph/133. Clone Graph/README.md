## 133. Clone Graph

🔗 [Link](https://leetcode.com/problems/clone-graph/description/)

**📝 Topic: DFS, HashMap**

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

> class Node {  
    public int val;  
    public List<Node> neighbors;  
}  
 
Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

**Example 1:**

```md
   1 --- 2
   |     |
   4 --- 3
```

> Input: adjList = [[2,4],[1,3],[2,4],[1,3]]  
Output: [[2,4],[1,3],[2,4],[1,3]]  
Explanation: There are 4 nodes in the graph.  
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).  
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).  
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).  
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).  

**Example 2:**


> Input: adjList = [[]]  
Output: [[]]  
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.  

**Example 3:**

> Input: adjList = []  
Output: []  
Explanation: This an empty graph, it does not have any nodes.  
 
**Constraints:**

- The number of nodes in the graph is in the range [0, 100].
- 1 <= Node.val <= 100
- Node.val is unique for each node.
- There are no repeated edges and no self-loops in the graph.
- The Graph is connected and all nodes can be visited starting from the given node.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the graph be empty? Yes, return empty
2. Can we have a node with no edge? Yes

### Match
_See if this problem matches any data structures, algorithms_

**Core Problem Challenge:**
We can't simply clone individual nodes - we must preserve the entire graph structure including all connections and avoid creating duplicate nodes.

Depth First Search (DFS) algorithm
- Traverse the graph to explore all nodes and their connections

HashMap:
- Maps original nodes to their cloned counterparts
- Prevents duplicate cloning of already-visited nodes
- Ensures all references point to the same cloned node instance

### Plan
_Walk through a implementation with an existing diagram_

Use **DFS recursion with memoization** to clone each node and its connections exactly once, maintaining graph structure:
1. Initialize HashMap
2. DFS Traversal
    - Base Case 1: Null Node
    - Already Cloned: If a node is already cloned (exists in map), return its reference
    - Recursive Case: Create a new node, add it to map, and recursively clone its neighbors
3. Stop this recursive path when we encounter a node that has already been cloned or visited


### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
Example Graph:
    1 --- 2
    |     |
    4 --- 3


1. dfs(node1):
   - Create copy1, map: {1→copy1}
   - Clone neighbors: dfs(node2), dfs(node4)

2. dfs(node2) [from node1's neighbor]:
   - Create copy2, map: {1→copy1, 2→copy2}  
   - Clone neighbors: dfs(node1), dfs(node3)

3. dfs(node1) [from node2's neighbor]:
   - Already in map! Return copy1 (prevents infinite loop)

4. dfs(node3) [from node2's neighbor]:
   - Create copy3, map: {1→copy1, 2→copy2, 3→copy3}
   - Clone neighbors: dfs(node2), dfs(node4)

5. dfs(node2) [from node3's neighbor]:
   - Already in map! Return copy2

6. dfs(node4) [from node3's neighbor]:
   - Create copy4, map: {1→copy1, 2→copy2, 3→copy3, 4→copy4}
   - Clone neighbors: dfs(node1), dfs(node3)

7. Both dfs(node1) and dfs(node3) return cached copies

Result: All nodes cloned with correct connections preserved
```

### Evaluate

Time Complexity: O(V + E)

where V is the number of vertices and E is the number of edges in the given graph

Space Complexity: O(n)

n is the number of nodes
