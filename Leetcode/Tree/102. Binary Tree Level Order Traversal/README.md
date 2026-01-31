## 102. Binary Tree Level Order Traversal

🔗 [Link](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)

**📝 Topic: Tree, BFS, Queue**

**Example 1:**

> Input: root = [3,9,20,null,null,15,7]  
Output: [[3],[9,20],[15,7]]


```md
           3
        /     \
       9       20
               / \
              15   7
```

**Example 2:**

> Input: root = [1]  
Output: [[1]]  

**Example 3:**

> Input: root = []  
Output: []  

**Constraints:**

- The number of nodes in the tree is in the range [0, 2000].
- -1000 <= Node.val <= 1000

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the tree be empty (null)? Yes, return empty array
2. Any requirement on time/space complexity? 

### Match
_See if this problem matches any data structures, algorithms_

📌 Concept to Remember!
- Queue (First in firt out) -> make it BFS
- Stack, Call stack -> make it DFS

### Plan
_Walk through a implementation with an existing diagram_

1. If the tree is empty, return an empty list.
2. Create a queue and push the root.
3. While the queue is not empty:
    - Get the length of current level
    - Create an empty list for current level
    - Loop through all the nodes in current queue
        - Pop a node from the queue
        - Add its value to current level
        - Push its left and right children if they exist
    - Add current level to the result list
4. Return the result list containing all levels.

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

### Evaluate

Time Complexity: O(n)

Space Complexity: O(n)
