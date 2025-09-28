## 20. Valid Parentheses

🔗 [Link](https://leetcode.com/problems/valid-parentheses/description/)

**📝 Topic: Stack(First in last out)**

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

**Example 1:**

> Input: s = "()"  
Output: true  

**Example 2:**

> Input: s = "()[]{}"  
Output: true  

**Example 3:**

> Input: s = "(]"  
Output: false  

**Example 4:**

> Input: s = "([])"  
Output: true  

**Example 5:**

> Input: s = "([)]"  
Output: false  

**Constraints:**

- 1 <= s.length <= 104
- s consists of parentheses only '()[]{}'.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input string be empty? No
2. Is it possible that string only have space? No

### Match
_See if this problem matches any data structures, algorithms_

Brute force:
- Continuously remove valid brackets until no more can be removed. If the remaining string is empty, return true; otherwise, return false.

Stack: 
- First in last out
- To store characters
- The stack is used to process the valid string, and it should be empty after the entire process.


### Plan
_Walk through a implementation with an existing diagram_

Ideas:
- For an opening bracket, push it onto the stack. If the bracket is a closing type, check for the corresponding opening bracket at the top of the stack. If we don't find the corresponding opening bracket, immediately return false. 
- Note: If there is opening bracket left in the stack, return flase

### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n)

Space Complexity: O(n)

n is the length of string