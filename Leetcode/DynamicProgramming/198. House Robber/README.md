## 198. House Robber

🔗 [Link](https://leetcode.com/problems/house-robber/)

**📝 Topic: DP, Recursion**

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

**Example 1:**

> Input: nums = [1,2,3,1]  
Output: 4  
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).  
Total amount you can rob = 1 + 3 = 4.  

**Example 2:**

> Input: nums = [2,7,9,3,1]  
Output: 12  
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).  
Total amount you can rob = 2 + 9 + 1 = 12.  

**Constraints:**

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 400

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Empty array? No

### Match
_See if this problem matches any data structures, algorithms_

Dynamic Programming (Space-Optimized)

- Bottom-up approach: Build solution iteratively from first to last house
- Optimal substructure: Maximum rob amount depends on optimal solutions for previous houses
- Overlapping subproblems: Same house positions solved multiple times in recursive approach


### Plan
_Walk through a implementation with an existing diagram_

1. Use two variables to track the maximum money that can be robbed up to the previous two positions, then iterate through houses making optimal decisions.
    - rob1: Maximum money robbed up to house (i-2)
    - rob2: Maximum money robbed up to house (i-1)
2. If we rob the current house, we skip the next house; otherwise, we move to the next house. The recurrence relation can be expressed as `max(nums[i] + dfs(i + 2), dfs(i + 1))`, where i is the current house and dfs is the recursive function.

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
Example: nums = [2, 7, 9, 3, 1]

Initial state:
rob1 = 0, rob2 = 0
[rob1, rob2, 2, 7, 9, 3, 1]

Iteration 1: n = 2
temp = max(0 + 2, 0) = 2
rob1 = 0, rob2 = 2
[rob1, rob2, 7, 9, 3, 1]

Iteration 2: n = 7
temp = max(0 + 7, 2) = 7
rob1 = 2, rob2 = 7
[rob1, rob2, 9, 3, 1]

Iteration 3: n = 9
temp = max(2 + 9, 7) = 11 (rob house 0 and house 2)
rob1 = 7, rob2 = 11
[rob1, rob2, 3, 1]

Iteration 4: n = 3
temp = max(7 + 3, 11) = 11 (better to skip house 3)
rob1 = 11, rob2 = 11
[rob1, rob2, 1]

Iteration 5: n = 1
temp = max(11 + 1, 11) = 12 (rob house 4)
rob1 = 11, rob2 = 12
[]

Result: rob2 = 12
Optimal path: Houses [0, 2, 4] = 2 + 9 + 1 = 12
```

### Evaluate

Time Complexity: O(n)

Space Complexity: O(n)

Where n is the number of houses