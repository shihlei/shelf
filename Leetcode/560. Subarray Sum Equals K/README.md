## 560. Subarray Sum Equals K
🔗 [Link](https://leetcode.com/problems/subarray-sum-equals-k/description/)

**📝 Topic: HashMap, Array**

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

**Example 1:**

Input: nums = [1,1,1], k = 2

Output: 2

**Example 2:**

Input: nums = [1,2,3], k = 3

Output: 2

---

### Understand
Verify the constraints and ask questions. Can also go through some test case

1. Can this input be ampty? -> No, at lease one number inside
2. Can the number be negative? -> Yes
3. Any requirement on time/space complexity? -> O(n)

### Match
See if this problem matches any data structures, algorithms

Brute Force: Check all the possible subarray. Time complexity will be O(n^2)

Use PrefixSum with a HashMap that counts how many times each prefix sum has appeared:
- Prefix sum up to index i is nums[0] + … + nums[i].
- If currentSum is the running prefix sum, **any earlier prefix sum equal to [currentSum − k] marks a subarray that sums to k.**
- Store counts of prefix sums in a HashMap so you can add **freq[currentSum − k]** to the answer in O(1).


### Plan
Walk through a implementation with an existing diagram

Compute prefix sums while iterating once, and count matches [currentSum − k]:
1. Initialize a map with {0: 1}. This represents an empty prefix before the array starts, so subarrays starting at index 0 can be counted.
2. Iterate through nums:
    - Update currentSum by adding the current number.
    - Look up need = currentSum − k. If it exists in the map, add its count to the answer.
    - Increase the count of currentSum in the map.
6. Return the answer.

🔖 Walkthrough (nums = [1, 1, 1], k = 2):

Map starts as {0:1}, sum = 0, ans = 0

See 1: currentSum=1, need=1-2=−1, ans=0, map becomes {0:1, 1:1}

See 1: currentSum=2, need=2-2=0, ans=1, map becomes {0:1, 1:1, 2:1}

See 1: currentSum=3, need=3-2=1, ans=1+1=2, map becomes {0:1, 1:1, 2:1, 3:1}

Answer is 2.


### Implement
See the code file

### Review
Go throgh the code step by step with examples and check any mistakes


### Evaluate

Time Complexity: O(n) which N is the number of integer in the array nums

Space Complexity: O(n) for HashMap
