## 207. Course Schedule

🔗 [Link](https://leetcode.com/problems/course-schedule/description/?envType=problem-list-v2&envId=7p5x763&sorting=W3sic29ydE9yZGVyIjoiREVTQ0VORElORyIsIm9yZGVyQnkiOiJGUkVRVUVOQ1kifV0%3D&page=1)

**📝 Topic: Graph, DFS**

here are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

**Example 1:**

> Input: numCourses = 2, prerequisites = [[1,0]]  
Output: true  
Explanation: There are a total of 2 courses to take.   
To take course 1 you should have finished course 0. So it is possible.  

**Example 2:**

> Input: numCourses = 2, prerequisites = [[1,0],[0,1]]  
Output: false  
Explanation: There are a total of 2 courses to take.   
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.  
 

**Constraints:**

- 1 <= numCourses <= 2000
- 0 <= prerequisites.length <= 5000
- prerequisites[i].length == 2
- 0 <= ai, bi < numCourses
- All the pairs prerequisites[i] are unique.

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input be empty? must have 1 course
2. 


### Match
_See if this problem matches any data structures, algorithms_

We use DFS with cycle detection:
- While doing DFS, keep track of courses in the current recursion path.
- If we visit a course already in the current path → cycle found.
- If a course has no prerequisites left, it’s safe.


### Plan
_Walk through a implementation with an existing diagram_

1. Build a graph where each course points to its prerequisites.
2. Use a visitSet set to track the current DFS path.
3. For each course:
    - Run DFS.
    - If the course is already in visitSet, return false (cycle).
    - Recursively DFS its prerequisites.
4. After successfully processing a course, clear its prerequisite list (mark as done).
5. If all courses are processed without cycles, return true.

### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
numCourses = 3
prerequisites = [[0,1], [1,2]]

0 → 1 → 2

1️⃣ Build the Graph
{
  0: [1],      // course 0 needs course 1
  1: [2],      // course 1 needs course 2
  2: []        // course 2 needs nothing
}

2️⃣ DFS on Course 0
dfs(0):
  - preMap.get(0) = [1], not empty ✓
  - visitSet doesn't contain 0 ✓
  - Add 0 to visitSet → visitSet = {0}
  - Check prerequisite: dfs(1)
  
    dfs(1):
      - preMap.get(1) = [2], not empty ✓
      - visitSet doesn't contain 1 ✓
      - Add 1 to visitSet → visitSet = {0, 1}
      - Check prerequisite: dfs(2)
      
        dfs(2):
          - preMap.get(2) = [], EMPTY! ✅
          - Return true immediately
      
      - dfs(2) returned true ✅
      - Remove 1 from visitSet → visitSet = {0}
      - Set preMap[1] = [] (mark as done)
      - Return true
  
  - dfs(1) returned true ✅
  - Remove 0 from visitSet → visitSet = {}
  - Set preMap[0] = [] (mark as done)
  - Return true

3️⃣ DFS on Course 1
dfs(1):
  - preMap.get(1) = [], EMPTY! ✅ (already processed)
  - Return true immediately

4️⃣ DFS on Course 2
dfs(2):
  - preMap.get(2) = [], EMPTY! ✅
  - Return true immediately


Result: true ✅
All courses can be completed!
```

### Evaluate
Time Complexity: O(V+E)

Space Complexity: O(V+E)

Where V is the number of courses and E is the number of prerequisites.
