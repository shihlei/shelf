## 33. Search in Rotated Sorted Array

🔗 [Link](https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: Binary Search**

You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:

- [3,4,5,6,1,2] if it was rotated 4 times.
- [1,2,3,4,5,6] if it was rotated 6 times.

Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.

You may assume all elements in the sorted rotated array nums are unique,

A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?

**Example 1:**

Input: nums = [3,4,5,6,1,2], target = 1

Output: 4

**Example 2:**

Input: nums = [3,5,6,0,1,2], target = 4

Output: -1

**Constraints:**

- 1 <= nums.length <= 1000
- -1000 <= nums[i] <= 1000
- -1000 <= target <= 1000


----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input array be empty? No
2. If target not exist in the array, what to return? Return -1
3. Can there be negatice value in the input array? Yes
4. Any request with time and space? Time complexity should be O(logn)


### Match
_See if this problem matches any data structures, algorithms_

- Brute Force: Start checking from the beginning. Time complexity will be O(n), but we can do better here.
- Sorted Array -> **Binary search**, which can have O(logn) time complexity


### Plan
_Walk through a implementation with an existing diagram_

Keep standard binary search, but at each step identify which half is sorted, then decide if the target can lie in that half:

1. Set l = 0, r = nums.length - 1. While l <= r, compute mid = l + (r - l) / 2.
2. If nums[mid] == target, return mid.
3. Determine the sorted half:
   - If nums[l] <= nums[mid], the left half [l..mid] is sorted.
     If nums[l] <= target < nums[mid], move r = mid - 1, else move l = mid + 1.
   - Else the right half [mid..r] is sorted.
     If nums[mid] < target <= nums[r], move l = mid + 1, else move r = mid - 1.

4. If the loop ends, return -1.


### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(logn) where n is the size of the input array

Space Complexity: O(1) 
