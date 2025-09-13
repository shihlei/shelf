/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current!=null){
            //save the next node
            ListNode nextNode = current.next;

            // Reverse the link
            current.next = prev;
            
            // Move pointers forward
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
