## 242. Valid Anagram

🔗 [Link](https://leetcode.com/problems/valid-anagram/description/)

**📝 Topic: Array, Hash**

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

**Example 1:**

> Input: s = "anagram", t = "nagaram"  
Output: true  

**Example 2:**

> Input: s = "rat", t = "car"  
Output: false  

**Constraints:**

- 1 <= s.length, t.length <= 5 * 104
- s and t consist of lowercase English letters.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input array be empty? No

### Match
_See if this problem matches any data structures, algorithms_

Hashtable:
- We can just consider maintaining the frequency of each character. 
- We can do this by having two separate hash tables for the two strings.
- Then, we can check whether the frequency of each character in string s is equal to that in string t and vice versa.

Array:
- Use a size 26 array to add and decrease the number of each character
- Any of the index in array remained not 0 means not anagram
- 

### Plan
_Walk through a implementation with an existing diagram_

Use a character frequency array to verify that both strings contain exactly the same characters with the same counts:
1. Check the length of 2 strings. If not the same, return false directly
2. Initialize Character Count Array
3. Process both strings simultaneously. 
    - Converts character to index
4. Verify all counts are zero

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n+m) Where n is the length of string s and m is the length of string t.

Space Complexity: O(1) since we have at most 26 different characters.
