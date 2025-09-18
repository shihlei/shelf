## 124. Binary Tree Maximum Path Sum

🔗 [Link](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: Tree, DFS**

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

**Example 1:**

> Input: root = [1,2,3]  
Output: 6  
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.  

**Example 2:**

> Input: root = [-10,9,20,null,null,15,7]  
Output: 42  
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.  

**Constraints:**

- The number of nodes in the tree is in the range [1, 3 * 104].
- -1000 <= Node.val <= 1000

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can path be a single node? Yes
2. Empty tree? → Assume tree has at least one node
3. Any requirement on time/space complexity? O(n) for time


### Match
_See if this problem matches any data structures, algorithms_

Depth First Search (DFS):

We can use the DFS algorithm to traverse the tree. We maintain a global variable to track the maximum path sum. At each node, we first calculate the `maximum path sum from the left and right subtrees` by traversing them. After that, we compute the maximum path sum at the current node. This approach follows a post-order traversal, where we visit the subtrees before processing the current node.


### Plan
_Walk through a implementation with an existing diagram_

For each node, calculate:
- Maximum path starting from this node (to return to parent)
- Maximum path passing through this node (to update global maximum)

We return the maximum path sum from the current node to its parent, considering only one of the subtrees (either left or right) to extend the path. 

While calculating the left and right subtree path sums, we also ensure that we take the maximum with 0 to avoid negative sums, indicating that we should not include the subtree path in the calculation of the maximum path at the current node.


### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
Tree:        -10
            /   \
           9     20
                /  \
               15   7

Execution trace:
- maxPathDown(9): through=9, globalMax=9, return 9
- maxPathDown(15): through=15, globalMax=15, return 15
- maxPathDown(7): through=7, globalMax=15, return 7
- maxPathDown(20): leftMax=15, rightMax=7, through=20+15+7=42, globalMax=42, return 20+15=35
- maxPathDown(-10): leftMax=max(0,9)=9, rightMax=max(0,35)=35, through=-10+9+35=34, globalMax=42, return -10+35=25

Final result: 42 

```

### Evaluate

Time Complexity: O(n), n is the number of nodes in tree

Space Complexity: O(height) usually logn for balance tree

