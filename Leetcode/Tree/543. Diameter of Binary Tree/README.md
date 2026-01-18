## 543. Diameter of Binary Tree

🔗 [Link](https://leetcode.com/problems/diameter-of-binary-tree/description/)

**📝 Topic: Tree, DFS**

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

**Example 1:**

> Input: root = [1,2,3,4,5]  
Output: 3  
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].  

**Example 2:**

> Input: root = [1,2]. 
Output: 1
 
**Constraints:**

- The number of nodes in the tree is in the range [1, 104].
- 100 <= Node.val <= 100

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Empty tree? Return 0
2. One node? Return 0


### Match
_See if this problem matches any data structures, algorithms_

Depth First Search (DFS):
- Resursive DFS to find height of subtrees
- Diameter of a binary tree is the longest path between any two nodes. This path must go through some node, and at that node the path length is: (left subtree height) + (right subtree height)


### Plan
_Walk through a implementation with an existing diagram_

Idea:
While doing a DFS to compute heights, we can simultaneously track the
maximum left + right seen so far
1. Use DFS to compute the height of every subtree
    - Recursively get left height
    - Recursively get right height
    - Diameter through this node = left + right
    - Update the global answer with this diameter.
2. Height returned to parent = 1 + max(left, right)

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
root = [1,2,3,4,5]

        1
       / \
      2   3
     / \
    4   5

Step-by-step process:

- At node 4 (leaf):

Height = 1
Diameter through this node = 0 + 0 = 0

- At node 5 (leaf):

Height = 1
Diameter through this node = 0 + 0 = 0

- At node 2:

Left height (from node 4) = 1
Right height (from node 5) = 1
Diameter through this node = 1 + 1 = 2 ✓
Height returned = 1 + max(1, 1) = 2

- At node 3 (leaf):

Height = 1
Diameter through this node = 0 + 0 = 0

- At node 1 (root):

Left height (from node 2) = 2
Right height (from node 3) = 1
Diameter through this node = 2 + 1 = 3 ✓

* The answer is 3 (path: 4→2→1→3 or 5→2→1→3)

```



### Evaluate

Time Complexity: O(n) - visits each node once

Space Complexity: O(h) - recursion stack depth, where h is the height. If the tree is balanced -> O(logn)
