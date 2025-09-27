## 217. Contains Duplicate

🔗 [Link](https://leetcode.com/problems/contains-duplicate/description/)

**📝 Topic: Array, HashSet**

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

**Example 1:**

> Input: nums = [1,2,3,1]  
> Output: true  
> 
> Explanation:  
> The element 1 occurs at the indices 0 and 3.  

**Example 2:**

> Input: nums = [1,2,3,4]  
> Output: false  
>
> Explanation:  
> All elements are distinct.  

**Example 3:**

> Input: nums = [1,1,1,3,3,4,3,2,4,2]  
Output: true 

**Constraints:**

- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can input array be empty? No
2. Is array already sorted? No

### Match
_See if this problem matches any data structures, algorithms_

HashSet
- We can use a hash data structure like a hash set or hash map to store elements we've already seen. This will allow us to check if an element is a duplicate in constant time.

Sort
- We can sort array, then iterate through the array to check for connected elements are the same or not
- Time complexity will be O(nlogn), which can be improved

### Plan
_Walk through a implementation with an existing diagram_

1. Create a HashSet
2. Iterate through all the elements in array
3. Whenever the elements already existing in HashSet, then we return false. Otherwise, return true at the end

### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_

### Evaluate

Time Complexity: O(n)

Space Complexity: O(n)

n is the number of elements in array