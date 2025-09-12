## 347. Top K Frequent Elements

🔗 [Link](https://leetcode.com/problems/top-k-frequent-elements/description/?envType=company&envId=bytedance&favoriteSlug=bytedance-six-months)

**📝 Topic: Minheap**

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

**Example 1:**

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

**Example 2:**

Input: nums = [1], k = 1

Output: [1]

**Example 3:**

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

**Constraints:**

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104
- k is in the range [1, the number of unique elements in the array].
- It is guaranteed that the answer is unique.

----


### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input linkedList be empty? No
2. 1 <= K will be <= nums.length
3. Any requirement on time/space complexity?

### Match
_See if this problem matches any data structures, algorithms_

Min-Heap + HashMap
- Why Min-Heap?
  - We want to keep only the k most frequent elements. A min-heap allows us to easily remove the least frequent element when the heap exceeds size k.
- Use Min-Heap to maintain k most frequent elements
- Smallest frequency at the top (so we can remove less frequent elements)
- Use HashMap to count frequencies

### Plan
_Walk through a implementation with an existing diagram_

1. Count Frequencies: Use HashMap to count frequency of each element Time: O(n), Space: O(n)
2. Initialize Min-Heap: Elements ordered by frequency (smallest at top)
   ```java
   PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
       (a, b) -> a.getValue() - b.getValue() 
   );
   ```
3. Maintain Size-K Heap:
  - Add each entry to heap
  - If heap size > k, remove the least frequent element with poll()
  - Time: O(n log k) - we process n elements, each heap operation is O(log k)
4. Extract Results:
  - Poll remaining k elements from heap
  - Note: Since it's a min-heap, we get results in ascending frequency order
  - Fill result array backwards to get descending frequency order

### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

Time Complexity: O(n log k) where n = array length, k = number of top elements

Space Complexity: O(n) for the frequency map + O(k) for the heap = O(n)
