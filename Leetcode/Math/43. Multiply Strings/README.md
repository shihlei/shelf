## 43. Multiply Strings

🔗 [Link](https://leetcode.com/problems/multiply-strings/description/?envType=company&envId=bytedance&favoriteSlug=bytedance-three-months)

**📝 Topic: Math, array**

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.


**Example 1:**

> Input: num1 = "2", num2 = "3"  
Output: "6"  

**Example 2:**

> Input: num1 = "123", num2 = "456"  
Output: "56088"  
 

Constraints:

- 1 <= num1.length, num2.length <= 200
- num1 and num2 consist of digits only.
- Both num1 and num2 do not contain any leading zero, except the number 0 itself.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can there be negative value? No
2. Can inputs be empty? → Assume non-empty string
3. Any requirement on time/space complexity?


### Match
_See if this problem matches any data structures, algorithms_

Algorithm Choices:
- Elementary School Method: Multiply digit by digit with position shifts
- Array/List Processing: Managing intermediate results

### Plan
_Walk through a implementation with an existing diagram_

1. Check if either string is "0" → return "0"
2. Create result array of size m + n:
    - Size m + n to hold maximum possible digits
3. Multiply Each Pair: For each digit in num1 × each digit in num2
4. Handle Carries: Propagate carries through the result array
5. Convert result array to string, skipping leading zeros

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

Test Case 1: num1 = "123", num2 = "456"
```md
        1 2 3
    ×   4 5 6
    ----------
          1 8  (6 × 3 = 18)
        1 3    (6 × 2 = 12, shifted)
        7 3    (6 × 1 = 6, shifted)
        8 8    (5 × 3 = 15, shifted)
      1 8      (5 × 2 = 10, shifted)
      6 8      (5 × 1 = 5, shifted)
      8 0      (4 × 3 = 12, shifted)
    1 6        (4 × 2 = 8, shifted)  
    5          (4 × 1 = 4, shifted)

Final result array: [0,5,6,0,8,8] → "56088" 
```

### Evaluate

Time Complexity: O(m * n), where m is the length of the string num1 and n is the length of the string num2

Space Complexity: O(m + n) 