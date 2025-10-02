## 226. Invert Binary Tree

🔗 [Link](https://leetcode.com/problems/invert-binary-tree/description/)

**📝 Topic: Tree, DFS**

Given the root of a binary tree, invert the tree, and return its root.

**Example 1:**
> Input: root = [4,2,7,1,3,6,9]  
Output: [4,7,2,9,6,3,1]  

**Example 2:**
> Input: root = [2,1,3]  
Output: [2,3,1]  

**Example 3:**

> Input: root = []  
Output: []  

**Constraints:**

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Empty tree? Return null
2. One node? Return the root
3. Any requirement on time/space complexity?


### Match
_See if this problem matches any data structures, algorithms_

Depth First Search (DFS):
- At each node, we swap its left and right children by swapping their pointers. This inverts the current node, but every node in the tree also needs to be inverted. 


### Plan
_Walk through a implementation with an existing diagram_

Idea:
we recursively visit the left and right children and perform the same operation.
1. Base case: If the current node is null, we simply return
2. Swap its left and right children by swapping their pointers
3. Recursively visit the left and right children

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n), n is the number of nodes in tree

Space Complexity: O(n), for recursion stack

