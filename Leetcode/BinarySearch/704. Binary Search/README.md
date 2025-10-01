## 704. Binary Search

🔗 [Link](https://leetcode.com/problems/binary-search/description/)

**📝 Topic: Binary Search**

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

**Example 1:**

> Input: nums = [-1,0,3,5,9,12], target = 9  
Output: 4  
Explanation: 9 exists in nums and its index is 4  

**Example 2:**

> Input: nums = [-1,0,3,5,9,12], target = 2  
Output: -1  
Explanation: 2 does not exist in nums so return -1  
 
**Constraints:**

- 1 <= nums.length <= 104
- -104 < nums[i], target < 104
- All the integers in nums are unique.
- nums is sorted in ascending order.

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input string be empty? No
2. Is it possible that string only have space? No

### Match
_See if this problem matches any data structures, algorithms_

Binary Search
- Sorted
- We have l and r as the boundaries of the segment of the array in which we are searching. Try building conditions to eliminate half of the search segment at each step.


### Plan
_Walk through a implementation with an existing diagram_

Ideas:
1. We have l and r as the pointers for the array
2. We compare the target value with the mid by `l + (l-r)/2` of the segment
3. Return if target == mid
3. Moved the l and r pointer
    - If target < mid, moved r pointer to mid - 1
    - If target > mid, moved l pointer to mid + 1
4. Return -1 at the end if target not found

### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(logn)

Space Complexity: O(1)

where n is the size of the input array