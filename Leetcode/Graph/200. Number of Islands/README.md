## 200. Number of Islands

🔗 [Link](https://leetcode.com/problems/number-of-islands/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: Graph, DFS**

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

**Example 1:**

> Input: grid = [  
  ["1","1","1","1","0"],  
  ["1","1","0","1","0"],  
  ["1","1","0","0","0"],  
  ["0","0","0","0","0"]  
]  
Output: 1  

**Constraints:**

1 <= grid.length, grid[i].length <= 100
grid[i][j] is '0' or '1'.

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input board or word be empty? No, the smallest board would be 1 row and 1 column
2. What to return if there is no island? 0
3. Do diagonal connections between lands count towards forming an island? No


### Match
_See if this problem matches any data structures, algorithms_

This question can be done with both DFS and BFS.

Depth First Search (DFS)
- We need to explore each connected component (island) completely before moving to the next

### Plan
_Walk through a implementation with an existing diagram_

We can use the DFS algorithm to traverse each group independently: 
1. Init directions and result:
- Define directions array for easy 4-directional movement
- Initialize island counter
2. We iterate through each cell of the grid. When we encounter a 1, we perform a DFS starting at that cell and recursively visit every other 1 that is reachable. we increment our ans counter because we've found a new island. 
3. DFS traversal:
    - Base case: Return if out of bounds or current cell is water ('0')
    - Mark current cell: Change '1' to '0' (mark as visited)
    - Recursive exploration: DFS on all 4 adjacent cells
4. Return total island count

### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

m is the number of rows and n is the number of columns in the grid.

Time Complexity: O(m*n)

Space Complexity: O(m*n)
from recursion stack, which can be up to O(m*n) (if entire grid is one island)