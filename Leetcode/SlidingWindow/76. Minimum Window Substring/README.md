## 76. Minimum Window Substring

🔗 [Link](https://leetcode.com/problems/minimum-window-substring/description/)

**📝 Topic: Sliding Window, HashMap**

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

**Example 1:**

> Input: s = "ADOBECODEBANC", t = "ABC"  
Output: "BANC"  
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.  

**Example 2:**

> Input: s = "a", t = "a"  
Output: "a"  
Explanation: The entire string s is the minimum window.  

**Example 3:**

Input: s = "a", t = "aa"  
Output: ""  
Explanation: Both 'a's from t must be included in the window.  
Since the largest window of s only has one 'a', return empty string.  

**Constraints:**

- m == s.length
- n == t.length
- 1 <= m, n <= 105
- s and t consist of uppercase and lowercase English letters.


----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can string t or s be empty? Yes, return ""
2. Not exist? Return ""
3. Any requirement on time/space complexity?

### Match
_See if this problem matches any data structures, algorithms_

Sliding Window + Two HashMaps
- Sliding Window: Expand right pointer to include characters, shrink left pointer to minimize window
- HashMap for Target Counting: Track required character frequencies from string t
- HashMap for Window Tracking: Track current character frequencies in sliding windo

### Plan
_Walk through a implementation with an existing diagram_

Use expanding and contracting sliding window with character frequency matching to find the minimum valid window.
1. Setup countT HashMap 
2. Exoend window with right pointer and check if character requirement is satisfied
    - Expanding: Add characters until window is valid (have == need)
    - 
3. Updated result if current window is smaller then try to shrink window from left
    - Check if removing left character breaks a reqirement
    - Move left pointer

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

### Evaluate

Time Complexity: O(n), where n is the length of the string s

Space Complexity: O(m), where m is the number of unique characters in s and t
