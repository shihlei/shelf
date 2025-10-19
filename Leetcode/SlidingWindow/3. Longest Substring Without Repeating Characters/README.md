## 3. Longest Substring Without Repeating Characters

🔗 [Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: Sliding window, HashSet**

Given a string s, find the length of the longest substring without duplicate characters.

**Example 1:**

>Input: s = "abcabcbb"  
Output: 3  
Explanation: The answer is "abc", with the length of 3.  

**Example 2:**

>Input: s = "bbbbb"  
Output: 1  
Explanation: The answer is "b", with the length of 1.  

**Constraints:**

- 0 <= s.length <= 5 * 104
- s consists of English letters, digits, symbols and spaces.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can string be empty? return 0
2. All the same characters? return 1
3. Case sensitivity? → Assume case matters ('A' ≠ 'a')

### Match
_See if this problem matches any data structures, algorithms_

1. Sliding Window: Expand/contract window to maintain valid substring
2. Two Pointers: Left and right boundaries of current window
3. Hash Set/Map: Track characters in current window

Best Match: Sliding Window with HashMap (most efficient)

### Plan
_Walk through a implementation with an existing diagram_

Use sliding window technique with two pointers and a HashMap to track character positions.

1. Initialize: Left pointer, right pointer, HashMap, max length
2. Expand Window: Move right pointer, add characters to HashMap
3. Handle Duplicates: When duplicate found, move left pointer past previous occurrence
4. Update Result: Track maximum window size seen so far
5. Continue: Repeat until right pointer reaches end

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

Cases:

- `""` → 0 ✓
- `"a"` → 1 ✓
- `"abcdef"` → 6 ✓
- `"aa"` → 1 ✓

### Evaluate

Time Complexity: O(n) where n is the number of characters

Space Complexity: O(n) for hashset
