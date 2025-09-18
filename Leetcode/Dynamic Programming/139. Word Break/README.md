## 139. Word Break

🔗 [Link](https://leetcode.com/problems/word-break/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: DP**

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.


**Example 1:**

> Input: s = "leetcode", wordDict = ["leet","code"]  
Output: true  
Explanation: Return true because "leetcode" can be segmented as "leet code".  

**Example 2:**

> Input: s = "applepenapple", wordDict = ["apple","pen"]  
Output: true  
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".  
Note that you are allowed to reuse a dictionary word.  

**Example 3:**

> Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]  
Output: false  

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Empty string? Assume s is non-empty
2. Empty dictionary? Return false (cannot segment)
3. Any requirement on time/space complexity?

### Match
_See if this problem matches any data structures, algorithms_

Dynamic Programming: Bottom-up approach, optimal substructure
- String Segmentation: Break string into valid parts
- Dictionary Lookup: Check if substrings exist in word set
- Decision Problem: Boolean result (exists/doesn't exist)
- Subproblem Structure: If s[0:i] can be segmented, can s[0:j] be segmented?

### Plan
_Walk through a implementation with an existing diagram_

1. Initialize: dp[0] = true (empty string can always be segmented)
2. Fill DP Array: For each position i from n-1 to 0:
    - For each word in dictionary:
        - If word matches substring starting at i:
            - Set dp[i] = dp[i + word.length()]
        - If dp[i] becomes true, break (early termination)
3. Return: dp[0]

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

```md
Initialize: dp = [F,F,F,F,F,F,F,F,T]
            i =  0 1 2 3 4 5 6 7 8

i=7: Try words at position 7
dp[7] remains false

i=6: Try words at position 6  
dp[6] remains false

i=5: Try words at position 5
dp[5] remains false

i=4: Try words at position 4
"code": s[4:8] = "code" ✓ MATCHES!
dp[4] = dp[4 + 4] = dp[8] = true ✓
Break early (found valid segmentation)

i=3: Try words at position 3
dp[3] remains false

i=2: Try words at position 2
dp[2] remains false

i=1: Try words at position 1  
dp[1] remains false

i=0: Try words at position 0
"leet": s[0:4] = "leet" ✓ MATCHES!
dp[0] = dp[0 + 4] = dp[4] = true ✓
Break early (found valid segmentation)

Final: dp = [T,F,F,F,T,F,F,F,T]
Result: dp[0] = true
```

### Evaluate

Time Complexity: O(n∗m∗t)

n is hte length of string s, m is the numver of words in wordDict, and t is the max length of any word in wordDict

Space Complexity: O(n)