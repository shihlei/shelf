## 994. Rotting Oranges

🔗 [Link](https://leetcode.com/problems/rotting-oranges/description/)

**📝 Topic: Graph, BFS(multi sources)**

You are given an m x n grid where each cell can have one of three values:

- 0 representing an empty cell,
- 1 representing a fresh orange, or
- 2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

**Example 1:**

> Input: grid = [[2,1,1],[1,1,0],[0,1,1]]  
Output: 4  

```md
Input:
grid = [
  [2, 1, 1],
  [1, 1, 0],
  [0, 1, 1]
]
```

**Example 2:**

> Input: grid = [[2,1,1],[0,1,1],[1,0,1]]  
Output: -1    
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.  

**Example 3:**

> Input: grid = [[0,2]]  
Output: 0  
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.  

**Constraints:**

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 10
- grid[i][j] is 0, 1, or 2.

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Is it possible that never rotten? Yes, return -1
2. Can we start with more then 1 rotten orange? Yes
3. C -> Can the pointers be null? Yes, check in c code for grid and the pointers to number of rows and cols


### Match
_See if this problem matches any data structures, algorithms_

1. DFS: is not working for this solution. The rotten oranges start to rot at the same time when the graph start with at least 2 rotten orange.
2. multi-source BFS: 
    - *Key Insight*: All initially rotten oranges start spreading simultaneously, so we add ALL rotten oranges to the queue at the beginning.
    - Each BFS level represents 1 minute.
    - If a fresh orange is reached, it becomes rotten in the next minute.


### Plan
_Walk through a implementation with an existing diagram_

Start BFS from all rotten oranges together
1. Find all initially rotten oranges (add to queue)
2. count total number of oranges
3. BFS level by level (each level = 1 minut)
    - While the queue is not empty and fresh oranges exist
        - Process all nodes in the queue (1 BFS level)
        - For each rotten orange:
            - Check its 4 neighbors
            - If a neighbor is fresh
                - Make it rotten
                - Decrease **fresh** count
                - Add it to the queue
        - Increment time by 1
4. Return minutes if all fresh oranges rotted, else -1


### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_


```
Initial State (Minute 0):

[2, 1, 1]    R = Rotten (2)
[1, 1, 0]    F = Fresh (1)
[0, 1, 1]    E = Empty (0)

// Initially rotten orange
queue = [(0,0)] 
freshCount = 6

- Minute 1:
Process (0,0) - the initially rotten orange:

Check neighbors of (0,0):
  - Up: out of bounds ✗
  - Down: (1,0) is fresh → rot it!
  - Left: out of bounds ✗
  - Right: (0,1) is fresh → rot it!

[2, 2, 1]
[2, 1, 0]
[0, 1, 1]

queue = [(1,0), (0,1)]
freshCount = 4
minutes = 1

- Minute 2:
Process (1,0) and (0,1):
....


```

### Evaluate

Time Complexity: O(m * n)

Space Complexity: O(m * n) for queue

m is the number of rows and n is the number of columns in grid
