## 322. Coin Change

🔗 [Link](https://leetcode.com/problems/coin-change/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days)

**📝 Topic: DP, Greedy**

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

**Example 1:**

> Input: coins = [1,2,5], amount = 11  
Output: 3  
Explanation: 11 = 5 + 5 + 1  

**Example 2:**

> Input: coins = [2], amount = 3  
Output: -1  

**Example 3:**

> Input: coins = [1], amount = 0  
Output: 0  
 
**Constraints:**

- 1 <= coins.length <= 12
- 1 <= coins[i] <= 231 - 1
- 0 <= amount <= 104

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input array be empty? 
2. Any requirement on time/space complexity?

### Match
_See if this problem matches any data structures, algorithms_

Dynamic Programming - Bottom-Up Approach
- Optimal Substructure: The minimum coins for amount i depends on minimum coins for smaller amounts
- Overlapping Subproblems: Same subproblems (smaller amounts) are solved multiple times
- State definition: What dp[i] represents

### Plan
_Walk through a implementation with an existing diagram_

DP: 

By solving smaller sub-problems and using their results to solve larger ones, find the minimum number of coins needed to make up a given amount, where you have an unlimited supply of each coin in the given denominations (Bottom-Up Approach)

1. Initialize DP Array
- Size: amount + 1 (to include dp[0] through dp[amount])
- Initial Value: amount + 1 (represents impossible/infinity)
- Why amount + 1? Maximum possible coins needed is amount (using all 1-cent coins)
2. Set base case
3. Fill DP Array (Bottom-Up)


### Implement
_See the solution file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity:  O(amount × coins.length)

Space Complexity: O(amount) for the DP array


