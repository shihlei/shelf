class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // Divide and conquer: merge lists in pairs like merge sort. After log k rounds you get one list.
        if(lists == null || lists.length == 0){
            return null;
        }

        while (lists.length > 1) {
            // put merged list into a new list
            List<ListNode> mergedLists = new ArrayList<>();

            // Iterate throught list
            for(int i =0; i< lists.length; i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i+1] : null;// list 2 might out of bound
                mergedLists.add(mergeList(l1, l2));
            }

            // updated 
            lists = mergedLists.toArray(new ListNode[0]);
        }

        // one have 1 list in the end
        return lists[0];
    }

    // merge two sorted linkedlist
    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null){
            tail.next = l1;
        }

        if(l2 != null){
            tail.next = l2;
        }

        return dummy.next;
    } 
}
