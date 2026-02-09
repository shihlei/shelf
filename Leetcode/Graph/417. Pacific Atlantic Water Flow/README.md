## 417. Pacific Atlantic Water Flow

🔗 [Link](https://leetcode.com/problems/pacific-atlantic-water-flow/description/)

**📝 Topic: Graph, BFS, DFS**

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

**Example 1:**

```md
     P   P   P   P   P
P  [ 1,  2,  2,  3,  5 ] A
P  [ 3,  2,  3,  4,  4 ] A
P  [ 2,  4,  5,  3,  1 ] A
P  [ 6,  7,  1,  4,  5 ] A
P  [ 5,  1,  1,  2,  4 ] A
     A   A   A   A   A

Water flow rule: Water can flow from a cell to adjacent cells (up/down/left/right) if the adjacent cell has equal or lower height.
```

> Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]  
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]  
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean   
       [0,4] -> Atlantic Ocean  
[1,3]: [1,3] -> [0,3] -> Pacific Ocean   
       [1,3] -> [1,4] -> Atlantic Ocean  
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean   
       [1,4] -> Atlantic Ocean  
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean   
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean  
[3,0]: [3,0] -> Pacific Ocean   
       [3,0] -> [4,0] -> Atlantic Ocean  
[3,1]: [3,1] -> [3,0] -> Pacific Ocean   
       [3,1] -> [4,1] -> Atlantic Ocean  
[4,0]: [4,0] -> Pacific Ocean   
       [4,0] -> Atlantic Ocean  
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.  

**Example 2:**

> Input: heights = [[1]]  
Output: [[0,0]]  
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.  

**Constraints:**

- m == heights.length
- n == heights[r].length
- 1 <= m, n <= 200
- 0 <= heights[r][c] <= 105


----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input board m n be empty? No, the smallest board would be 1 row and 1 column
2. What to return if there is way to drain the water? empty array
3. If it's a 1 cell matrix? Return [[0,0]]
4. Is the result need to be sepecific order? No
5. C -> Can the pointers be null?

### Match
_See if this problem matches any data structures, algorithms_

1. One way is to traverse all the cell and do DFS. -> Time Complexity is O(m × n × 4^(m×n))
2. Start from boundaries. Find cells that can reach Pacific Ocean & Find cells that can reach Atlantic Ocean ->  Find intersection (cells reachable from BOTH oceans)

### Plan
_Walk through a implementation with an existing diagram_

Start from boundaries
1. Find cells that can reach Pacific Ocean
    - Start DFS from Pacific boundaries (top row and left column) and work backwards - find which cells can flow water TO the ocean (or equivalently, which cells the ocean can reach flowing uphill).
2. Find cells that can reach Atlantic Ocean
    - Start DFS from Atlantic boundaries (bottom row and right column).
3. Find intersection (cells reachable from BOTH oceans)
    - Overlay both maps and find cells marked with both P and 



### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_

```md

Pacific:              Atlantic:             Both (Result):
P P P P P             . . . . A             . . . . *
P P P P P             . . . A A             . . . * *
P P P P .             . A A A A             . * * * .
P P . . .             A A A A A             * * . . .
P . . . .             A A A A A             * . . . .

```

```md
After filling result for c:
```
result → [ ptr0 ] → [ 0, 4 ]
         [ ptr1 ] → [ 1, 3 ]
         [ ptr2 ] → [ 1, 4 ]
         [ ptr3 ] → [ 2, 2 ]
         [ ptr4 ] → [ 3, 0 ]
         [ ptr5 ] → [ 3, 1 ]
         [ ptr6 ] → [ 4, 0 ]
         
returnColumnSizes → [ 2, 2, 2, 2, 2, 2, 2 ]

```

### Evaluate

Time Complexity: O(m*n)

Space Complexity: O(m*n)

Where m is the number of rows and n is the number of columns.
