## 136. Single Number

🔗 [Link](https://leetcode.com/problems/single-number/description/)

**📝 Topic: Bit Manipulation, Array**

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

**Example 1:**

> nput: nums = [2,2,1]  
Output: 1  

**Example 2:**

> Input: nums = [4,1,2,1,2]  
Output: 4  

**Example 3:**

> Input: nums = [1]  
Output: 1  

**Constraints:**

- 1 <= nums.length <= 3 * 104
- -3 * 104 <= nums[i] <= 3 * 104
- Each element in the array appears twice except for one element which appears only once.

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Time and space? O(n) time and constant O(1) space
2. C -> Can the pointers be null? Yes


### Match
_See if this problem matches any data structures, algorithms_

1. HashSet can store elements and remove elements alreayd there. O(n) space
2. XOR Bit Manipulation: all numbers that appear twice will cancel each other out
    - a ^ a = 0 (any number XOR itself = 0)
    - a ^ 0 = a (any number XOR 0 = itself)
    - XOR is commutative and associative, so order does not matter

### Plan
_Walk through a implementation with an existing diagram_

1. Initialize res = 0.
2. Iterate through each number in the array:
    - update res = res ^ num
3. After processing all numbers: res contains the single number
4. Return res


### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
Example 1: `nums = [2, 2, 1]`

Initial: result = 0

Step 1: result = 0 ^ 2 = 2
Binary:
  0000 0000  (0)
^ 0000 0010  (2)
-----------
  0000 0010  (2)


Step 2: result = 2 ^ 2 = 0
Binary:
  0000 0010  (2)
^ 0000 0010  (2)
-----------
  0000 0000  (0)  ← Pairs cancel out!


Step 3: result = 0 ^ 1 = 1
Binary:
  0000 0000  (0)
^ 0000 0001  (1)
-----------
  0000 0001  (1)

Return: 1 ✅


```

### Evaluate

Time Complexity: O(n)

Space Complexity: O(1)

