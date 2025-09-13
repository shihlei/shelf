## 92. Reverse Linked List II

🔗 [Link](https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=company&envId=bytedance&favoriteSlug=bytedance-three-months)

**📝 Topic: LinkedList**

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

**Example 1:**


>Input: head = [1,2,3,4,5], left = 2, right = 4    
Output: [1,4,3,2,5]   

**Example 2:**

> Input: head = [5], left = 1, right = 1    
Output: [5]   
 
**Constraints:**

- The number of nodes in the list is n.
- 1 <= n <= 500
- -500 <= Node.val <= 500
- 1 <= left <= right <= n

----

### Understand
_Verify the constraints and ask questions. Can also go through some test case_

1. Can the input linkedList be empty? No, at least 1 node
2. Is linkedList have cycle? No
3. Any requirement on time/space complexity? Could you do it in one pass?

### Match
_See if this problem matches any data structures, algorithms_

- Dummy Node:
    - Make things easier, so does not need to handle edge case


### Plan
_Walk through a implementation with an existing diagram_

Navigate to Position:
1. Create dummy node to handle edge case where left = 1
2. Find the node before left position:
    - Use leftPrev pointer to track the node right before position left
    - Use current pointer to reach the left node
    - Take left - 1 iterations to position pointers correctly

Reverse the Sublist:

3. Apply standard reversal for exactly right - left + 1 nodes:
    - Save next node, reverse current link, move pointers forward
    - After reversal: prev points to the new head of reversed section

Reconnect the List:
4. Update connections:
    - Connect the node before left to the new head of reversed section
    - Connect the tail of reversed section to the node after right


### Implement
_See the code file_


### Review
_Go throgh the code step by step with examples and check any mistakes_


### Evaluate



Time Complexity: 

Space Complexity: 
