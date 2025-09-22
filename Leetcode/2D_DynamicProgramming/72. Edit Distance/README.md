## 72. Edit Distance

🔗 [Link](https://leetcode.com/problems/edit-distance/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: 2D Dynamic Programming, Two Pointers**

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

**Example 1:**

> Input: word1 = "horse", word2 = "ros"  
Output: 3  
Explanation:   
horse -> rorse (replace 'h' with 'r')  
rorse -> rose (remove 'r')  
rose -> ros (remove 'e')  

**Example 2:**

Input: word1 = "intention", word2 = "execution"  
Output: 5  
Explanation:   
intention -> inention (remove 't')  
inention -> enention (replace 'i' with 'e')  
enention -> exention (replace 'n' with 'x')  
exention -> exection (replace 'n' with 'c')  
exection -> execution (insert 'u')  
 

**Constraints:**

- 0 <= word1.length, word2.length <= 500
- word1 and word2 consist of lowercase English letters.

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can strings be empty? → Yes, need to handle empty strings
2. Same string? → Return 0 operations
3. Any requirement on time/space complexity?


### Match
_See if this problem matches any data structures, algorithms_

2D Dynamic Programming:
1. Optimal substructure: Minimum operations for substrings
2. Overlapping subproblems: Same subproblems solved multiple times
3. Bottom-up construction: Build solution from smaller subproblems

### Plan
_Walk through a implementation with an existing diagram_

Relation:
```md
if (word1[i] == word2[j]):
    dp[i][j] = dp[i+1][j+1]  // Characters match, no operation needed
else:
    dp[i][j] = 1 + min(
        dp[i][j+1],      // Insert word2[j] into word1
        dp[i+1][j],      // Delete word1[i]
        dp[i+1][j+1]     // Replace word1[i] with word2[j]
    )
```

1. Initialize DP table with dimensions (m+1)*(n+1)
2. Fill with base case: Bottom row and rightmost column
3. Fill DP table backwords: From bottom-right to top-left
4. Return dp[0][0] as final answer

```md
    j→  0   1   2   3   (word2 = "ros")
i↓      r   o   s   ""
0   h   ?   ?   ?   5
1   o   ?   ?   ?   4  
2   r   ?   ?   ?   3
3   s   ?   ?   ?   2
4   e   ?   ?   ?   1
5   ""  3   2   1   0

Fill from dp[4][2] towards dp[0][0]
```

### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_

Test Case: word1 = "horse", word2 = "ros"

```md
    j→  0   1   2   3   (word2 = "ros")
i↓      r   o   s   ""
0   h   3   3   4   5
1   o   3   2   3   4  
2   r   2   2   2   3
3   s   3   2   1   2
4   e   3   2  `1`  1
5   ""  3   2   1   0

Fill from dp[4][2] towards dp[0][0]

Result: dp[0][0] = 3

```

### Evaluate

Time Complexity: O(m × n)

Space Complexity: O(m × n) 