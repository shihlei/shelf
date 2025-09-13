class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode leftPrev = dummy;
        ListNode current = head;

        // Reach node right before postion "left"
        for(int i =0 ; i< left - 1;i++){
            leftPrev = current;
            current = current.next;
        }

        // Now, current = left, leftPrev = node before left
        // reverse from the left to right
        ListNode prev = null;
        for(int i = 0; i < right - left +1 ; i++){
            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }

        // update pointers
        leftPrev.next.next = current; // current is hte node after "right"
        leftPrev.next = prev; // prev is at the position "right"

        return dummy.next;
    }
}