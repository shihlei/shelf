## 23. Merge k Sorted Lists

🔗 [Link](https://leetcode.com/problems/merge-k-sorted-lists/description/)

**📝 Topic: LinkedList**

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

**Example 1:**

Input: lists = [[1,2,4],[1,3,5],[3,6]]

Output: [1,1,2,3,3,4,5,6]

**Example 2:**

Input: lists = []

Output: []

**Example 3:**

Input: lists = [[]]

Output: []

**Constraints:**

- 0 <= lists.length <= 1000
- 0 <= lists[i].length <= 500
- -1000 <= lists[i][j] <= 1000


----


### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input linkedList be empty? Yes, return empty [] in this case
2. Is linkedList have cycle? No
3. Any requirement on time/space complexity? O(nlogk) for time

### Match
_See if this problem matches any data structures, algorithms_

1.  Divide and conquer: Merge lists in pairs like merge sort. After log k rounds you get one list.
2.  Or using PriorityQueue minheap: min value at the top

### Plan
_Walk through a implementation with an existing diagram_

Idea:

Using Divide and conquer here to merge lists in pairs like merge sort. After log k rounds you get one list:
1. Walk lists two at a time: i and i+1.
2. Merge those two into a single sorted list using a dummy head and a moving tail pointer.
3. Collect all merged results into a new array.
4. Repeat until only one list remains.


### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

n is the total number of nodes in all the linkedlist and k is the number of linkedlist

Time Complexity: O(nlogk)

Space Complexity: O(k)
