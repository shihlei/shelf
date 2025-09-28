## 121. Best Time to Buy and Sell Stock

🔗 [Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

**📝 Topic: Sliding window**

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

**Example 1:**

> Input: prices = [7,1,5,3,6,4]  
Output: 5  
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.  
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.  

**Example 2:**

> Input: prices = [7,6,4,3,1]  
Output: 0  
Explanation: In this case, no transactions are done and the max profit = 0.  
 

**Constraints:**

- 1 <= prices.length <= 105
- 0 <= prices[i] <= 104

---


### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input string be empty? No
2. If no transactions, return 0

### Match
_See if this problem matches any data structures, algorithms_

Brute force: 
- Trying all possible options for selling it on the days to the right of index i
- Time complexity will be O(n^2)

Sliding window:
- We are trying to maximize profit = sell - buy
- If the current i is the sell value, we want to choose the minimum buy value to the left of i to maximize the profit


### Plan
_Walk through a implementation with an existing diagram_

Ideas:
1. Take the first value in array as the buy value
2. Iterate through the array with index i
    - update the profit by `sell - buy` and always store the max value
    - update the buy value if current value is smaller
3. If profit is negative, return 0. Return max profit

### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n)

Space Complexity: O(1)

where n is the size of the input array
