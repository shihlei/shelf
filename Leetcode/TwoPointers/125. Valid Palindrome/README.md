## 125. Valid Palindrome

🔗 [Link](https://leetcode.com/problems/valid-palindrome/description/https://leetcode.com/problems/valid-palindrome/description/)

**📝 Topic: Two Pointers**

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

**Example 1:**

> Input: s = "A man, a plan, a canal: Panama"  
Output: true  
Explanation: "amanaplanacanalpanama" is a palindrome.  

**Example 2:**

> Input: s = "race a car"  
Output: false  
Explanation: "raceacar" is not a palindrome.  

**Example 3:**

> Input: s = " "  
Output: true  
Explanation: s is an empty string "" after removing non-alphanumeric characters.  
Since an empty string reads the same forward and backward, it is a palindrome.  
 
**Constraints:**

- 1 <= s.length <= 2 * 105
- s consists only of printable ASCII characters.

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input string be empty? No
2. What does Alphanumeric characters consist of? letters `(A-Z, a-z)` and numbers `(0-9)`
3. Can a string only have space? Yes, return true

### Match
_See if this problem matches any data structures, algorithms_

Brute force: 
- create a copy of the string, reverse it, and then check for equality.
- This solution need extra space

Two pointers:
- palindrome string means the character at the start should match the character at the end at the same index
- We can have two pointers start from two side of string and move toward middle

### Plan
_Walk through a implementation with an existing diagram_

Ideas:
1. Init two pointers
2. Start from two side of string
3. First check if the characters at two pointers are Alphanumeric characters, if not move pointer
4. Check if the characters match. If not, return false directly. Return true at the end

### Implement
_See the code file_

### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n)

Space Complexity: O(1)

where n is the length of the input string