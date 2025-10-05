## 39. Combination Sum

🔗 [Link](https://leetcode.com/problems/combination-sum/description/)

**📝 Topic: Backtracking, DFS**

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

**Example 1:**

> Input: candidates = [2,3,6,7], target = 7  
Output: [[2,2,3],[7]]  
Explanation:  
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.  
7 is a candidate, and 7 = 7.  
These are the only two combinations.  

**Example 2:**

> Input: candidates = [2,3,5], target = 8  
Output: [[2,2,2,2],[2,3,3],[3,5]]  

**Example 3:**

> Input: candidates = [2], target = 1  
Output: []  
 
**Constraints:**

- 1 <= candidates.length <= 30
- 2 <= candidates[i] <= 40
- All elements of candidates are distinct.
- 1 <= target <= 40

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can target be 0? No
2. Can candidates be empty array or having the same value twice? No

### Match
_See if this problem matches any data structures, algorithms_

Backtracking + DFS (Decision Tree):
- Decision Tree Structure: At each position, we have two choices:
    - Include the current candidate (can reuse it)
    - Skip the current candidate (move to next)
- Backtracking: Explore all possible combinations, undo choices when path doesn't work
- DFS: Recursively explore paths depth-first until base case reached


### Plan
_Walk through a implementation with an existing diagram_

Use backtracking with two decisions at each step. Include current candidate or skip to next candidate:
1. Init the result arrayList
2. Recursively traverse the array starting from index i.
    - Base case: append the current list to the result whenever `current sum == target`.
    - At each step, we select an element from i to the end of the array.
    - Backtracking Pattern
        - Decision 1: Include candidates[i]
        - Backtrack: Undo choice -> Decision 2: Skip candidates[i]  


### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
candidates = [2,3,6,7], target = 7

                    []
         /                    \
    [2]                        [] (skip 2)
   /    \                     /        \
[2,2]  [2](skip 2)        [3]          [](skip 3)
 / \      / \             /  \           /    \
...  ... [2,3] ...     [3,3] [3]...   [6]    [7]✓
                        |     |         |
                     invalid [3,3,3]  [6,6]
                              |         |
                           invalid   invalid

Valid paths found: [2,2,3], [7]
```


### Evaluate

Time Complexity: O(2^t/m)

Space Complexity: O(t/m)

t is the target and m is the minimum value in candidates array