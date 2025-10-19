## 15. 3Sum

🔗 [Link](https://leetcode.com/problems/3sum/description/)

**📝 Topic: Two Pointers**

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

**Example 1:**

> Input: nums = [-1,0,1,2,-1,-4]  
Output: [[-1,-1,2],[-1,0,1]]  
Explanation:   
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.  
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.  
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.  
The distinct triplets are [-1,0,1] and [-1,-1,2].  
Notice that the order of the output and the order of the triplets does not matter.  

**Example 2:**

> Input: nums = [0,1,1]  
Output: []  
Explanation: The only possible triplet does not sum up to 0.  

**Example 3:**

> Input: nums = [0,0,0]  
Output: [[0,0,0]]  
Explanation: The only possible triplet sums up to 0.  
 

**Constraints:**

- 3 <= nums.length <= 3000
- -105 <= nums[i] <= 105

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input array be empty? No
2. What to return is there is no matching result? Return empty array []

### Match
_See if this problem matches any data structures, algorithms_

Brute force:
- O(n^3) time complexity

Sorting:
- O(nlogn) for time complexity
- Prevent check duplicate value in the array

Two pointers:
- Iterate through nums with index i and get `nums[i] = -(nums[j] + nums[k])` after rearranging the equation, making `-nums[i] = nums[j] + nums[k]`
- Two pointers to find the j and k pairs
- When we run two pointer algorithm, consider j and k as pointers and target = -nums[i]
    - if the current sum num[j] + nums[k] < target then we need to increase the value of current sum by incrementing j pointer
    - Else if the current sum num[j] + nums[k] > target then we should decrease the value of current sum by decrementing k pointer. 


### Plan
_Walk through a implementation with an existing diagram_

Use sorting + two-pointer to find all unique triplets that sum to zero by reducing the 3Sum problem into multiple 2Sum problems:
1. Sort input array
2. Process `nums[i]` as first element of triplet, amd find two elements from `nums[i+1...end]` that sum to `-nums[i]`
3. Skip duplicate fixed elements
4. Use Two-Pointer for 2Sum and handle 3 cases in 2Sum loop
    - Sum too large
    - Sum too small
    - Sum equals 0 (Found Triplet). Add the triplet, then skip duplicate values for left pointer

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(nlogn) for sorting + O(n^2) for loop = O(n^2)

Space Complexity: O(1)