## 424. Longest Repeating Character Replacement

🔗 [Link](https://leetcode.com/problems/longest-repeating-character-replacement/description/)

**📝 Topic: Sliding window**

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

**Example 1:**

> Input: s = "ABAB", k = 2  
Output: 4  
Explanation: Replace the two 'A's with two 'B's or vice versa.  

**Example 2:**

> Input: s = "AABABBA", k = 1  
Output: 4  
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".  
The substring "BBBB" has the longest repeating letters, which is 4.  
There may exists other ways to achieve this answer too.  
 
**Constraints:**

- 1 <= s.length <= 105
- s consists of only uppercase English letters.
- 0 <= k <= s.length

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can string be empty? No
2. 

### Match
_See if this problem matches any data structures, algorithms_

Need to replace less frequency character.

Sliding Window:
- The window size will be dynamic, and we will shrink the window when the number of replacements exceeds k

HashMap:
- Count for the frequency (max 26 characters size)

### Plan
_Walk through a implementation with an existing diagram_

Use sliding window with character frequency map to find the longest valid substring where we can make all characters the same with at most k replacements.
1. Initialize variables
2. Expand window (right pointer)
    - Expand window to include character at position r
    - Update frequency map with new character
3. Find maximum frequency in current window
    - Characters to replace = window_size - maxValue
4. Check window validity (shrink if needed)
    - If (window_size - max_frequency) > k: invalid window
    - Shrink from left until valid


### Implement
_See the solution file_

### Review
_Go throgh the code step by step with examples and check any mistakes_

### Evaluate

Time Complexity: O(n) where n is the number of characters

Space Complexity: O(26) for upper case char