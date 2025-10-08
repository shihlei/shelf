## 53. Maximum Subarray

🔗 [Link](https://leetcode.com/problems/maximum-subarray/description/)

**📝 Topic: Greedy, Sliding Window**

Given an integer array nums, find the subarray with the largest sum, and return its sum.


**Example 1:**

> Input: nums = [-2,1,-3,4,-1,2,1,-5,4]  
Output: 6  
Explanation: The subarray [4,-1,2,1] has the largest sum 6.  

**Example 2:**

> Input: nums = [1]  
Output: 1  
Explanation: The subarray [1] has the largest sum 1.  
**Example 3:**

>Input: nums = [5,4,-1,7,8]  
Output: 23  
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.  
 
**Constraints:**

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input array be empty? No
2. Can the array include negative values? Yes
3. If only one values in array, just return itself? Yes

### Match
_See if this problem matches any data structures, algorithms_

Brute force:
- Compute the sum of every subarray and return the maximum among them
- Time O(n^2)

Kadane's algorithm:
Instead of calculating the sum for every subarray, try maintaining a running sum

### Plan
_Walk through a implementation with an existing diagram_

1. We use a variable curSum to track the sum of the elements.
2. At each index, we have two choices:
    - Sdd the current element to curSum
    - start a new subarray by resetting curSum to the current element
3. Track the maximum sum at each step and update the global maximum accordingly

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n)

Space Complexity: O(1)

n is the size of the input array