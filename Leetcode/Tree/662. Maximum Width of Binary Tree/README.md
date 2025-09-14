## 662. Maximum Width of Binary Tree

🔗 [Link](https://leetcode.com/problems/maximum-width-of-binary-tree/description/)

**📝 Topic: Tree, BFS, Node Indexing**

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

**Example 1:**

> Input: root = [1,3,2,5,3,null,9]  
Output: 4  
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).  

**Example 2:**

> Input: root = [1,3,2,5,null,null,9,6,null,7]  
Output: 7  
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).  

**Constraints:**

- The number of nodes in the tree is in the range [1, 3000].
- -100 <= Node.val <= 100

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the tree be empty (null)? No, at least 1 node
3. Any requirement on time/space complexity? 

### Match
_See if this problem matches any data structures, algorithms_


- BFS: BFS processes nodes level by level - exactly what we need to calculate width at each level!
- Node Indexing
    - To assign index numbers to each node as if the tree were a complete binary tree
    - For any node at index i:
        - Left child is at index 2*i
        - Right child is at index 2*i + 1
        - Width of a level = rightmost_index - leftmost_index + 1

```md
       1
    /     \
   2       3
  / \     / \
 4   5   6   7
```

### Plan
_Walk through a implementation with an existing diagram_

1. Use Queue to Store (Node, Index) Pairs
2. Process Each Level
    - Track leftmost and rightmost indices
    - Add children with their calculated indices
    - Calculate width of current level and update with the max result


### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

Example Tree:
```md
       1
    /     \
   3       2
  /         \
 5           9
/           /
6           7

Level 0:
Queue: [(1, index=1)]
Width = 1 - 1 + 1 = 1
Level 1:
Queue: [(3, index=2), (2, index=3)]
Width = 3 - 2 + 1 = 2
Level 2:
Queue: [(5, index=4), (9, index=7)]
Width = 7 - 4 + 1 = 4
Level 3:
Queue: [(6, index=8), (7, index=14)]
Width = 14 - 8 + 1 = 7
Maximum Width = 7
```

### Evaluate

Time Complexity: O(n), n is the number of nodes in tree

Space Complexity: O(n)
