## 297. Serialize and Deserialize Binary Tree

🔗 [Link](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: Tree, DFS, BFS**

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

**Example 1:**

> Input: root = [1,2,3,null,null,4,5]  
> Output: [1,2,3,null,null,4,5]  

**Example 2:**

> Input: root = []  
Output: []  

**Constraints:**

- The number of nodes in the tree is in the range [0, 104].
- -1000 <= Node.val <= 1000

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can path be a single node? Yes
2. Empty tree? → return empty array
3. Any requirement on time/space complexity? O(n) for time


### Match
_See if this problem matches any data structures, algorithms_

1. BFS
2. DFS
    - Pre-order DFS for Serialization: Process root → left subtree → right subtree
    - Pre-order DFS for Deserialization: Reconstruct in same order (root → left → right)
    - Why Pre-order? Root-first processing allows immediate node creation during deserialization

### Plan
_Walk through a implementation with an existing diagram_

We can use the Depth First Search (DFS) algorithm for both serialization and deserialization. During serialization, we traverse the tree and add node values to the result string separated by a delimiter, `inserting N whenever we encounter a null node`. During deserialization, we process the serialized string using an index i, create nodes for valid values, and return from the current path whenever we encounter N, reconstructing the tree accurately.

**Serialization (Tree → String)**

1. Initialize: Create result list to collect node values
2. DFS Pre-order Traversal:
    - If node is null → add "N" (null marker)
    - If node exists → add node value, then recurse left, then right
3. Join Results: Convert list to comma-separated string

**Deserialization (String → Tree)**

1. Parse Input: Split comma-separated string into array
2. Initialize Index Tracker: Use int[] i = {0} for mutable index
3. DFS Reconstruction:
    - If current value is "N" → return null, advance index
    - Otherwise → create node, advance index, build left/right subtrees
4. Return Root: Reconstructed tree root

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

### Evaluate

Time Complexity: O(n), n is the number of nodes in tree

Space Complexity: O(n)