/*

Given the head of a linked list, remove the nth node from the end of the list and return its head.

*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) 
            return head;

        ListNode fast = head;
        for(int i=1; i<n; i++) {
            fast = fast.next;
        }
        ListNode prev = new ListNode(-1, head), slow = prev;
        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return prev.next;
    }
}
