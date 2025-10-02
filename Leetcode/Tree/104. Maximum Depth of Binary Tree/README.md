## 104. Maximum Depth of Binary Tree

🔗 [Link](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

**📝 Topic: Tree, DFS**

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Example 1:**

> Input: root = [3,9,20,null,null,15,7]  
Output: 3  

**Example 2:**

> Input: root = [1,null,2]  
Output: 2  
 
**Constraints:**

- The number of nodes in the tree is in the range [0, 104].
- -100 <= Node.val <= 100

---


### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Empty tree? Return 0
2. One node? Return 1
3. Any requirement on time/space complexity?


### Match
_See if this problem matches any data structures, algorithms_

Depth First Search (DFS):
- Resursive DFS to find max-depth of subtrees
- For the subtrees rooted at the left and right children of the root node, we calculate their maximum depths recursively going through left and right subtrees.

### Plan
_Walk through a implementation with an existing diagram_

Idea:
1. Base case: return when root is null
2. We return `1 + max(leftDepth, rightDepth)`
    - The +1 accounts for the current node, as it contributes to the current depth in the recursion call. 
    - We pass the maximum depth from the current node's left and right subtrees to its parent because the current maximum depth determines the longest path from the parent to a leaf node through this subtree.

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n), n is the number of nodes in tree

Space Complexity: O(n), for recursion stack or O(log(n)) for balanced tree
