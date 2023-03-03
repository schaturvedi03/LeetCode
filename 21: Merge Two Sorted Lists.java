/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(-1);
        ListNode curr = list;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        
        while(curr1!=null && curr2!=null){
            if(curr1.val<curr2.val){
                list.next = new ListNode(curr1.val);
                curr1 = curr1.next;
            } else {
                list.next = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            list = list.next;
        }
        
        while(curr1!=null){
            list.next = new ListNode(curr1.val);
            curr1 = curr1.next;
            list = list.next;
        }
        
        while(curr2!=null){
            list.next = new ListNode(curr2.val);
            curr2 = curr2.next;
            list = list.next;
        }
        
        return curr.next;
    }
}
