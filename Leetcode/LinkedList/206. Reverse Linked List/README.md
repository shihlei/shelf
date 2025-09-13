## 206. Reverse Linked List

🔗 [Link](https://leetcode.com/problems/reverse-linked-list/description/)

**📝 Topic: LinkedList**

Given the head of a singly linked list, reverse the list, and return the reversed list.

**Example 1:**

> Input: head = [1,2,3,4,5]  
Output: [5,4,3,2,1]  

**Example 2:**

> Input: head = [1,2]  
Output: [2,1]  

**Example 3:**

> Input: head = []  
Output: [] 


**Constraints:**

- The number of nodes in the list is the range [0, 5000].
- -5000 <= Node.val <= 5000

---

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input linkedList be empty (head is null)? Yes, return empty
2. Is linkedList have cycle? No
3. Any requirement on time/space complexity? O(N) in time and O(1) in space

### Match
_See if this problem matches any data structures, algorithms_

Moving pointers to reverse the linkedlist

### Plan
_Walk through a implementation with an existing diagram_

Initialize a previous node, current node, and a next node:
1. Initialize Three Pointers
    - current: The node we're currently reversing
    - prev: What current should point to (the reversed part)
    - nextNode: Saves the rest of the list before we lose it
2. The Reversal Process (While Loop)
    1. Save the next node
    2. Reverse the link
    3. Move pointers forward
3. Return previous node
    - When current becomes null, we've processed all nodes
    - prev points to the last node we processed (which is now the first node of reversed list)
    - prev is the new head of the reversed list


### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate

n is the total number of nodes in the linkedlist

Time Complexity: O(n)

Space Complexity: O(1)
