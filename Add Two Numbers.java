//https://leetcode.com/problems/add-two-numbers/
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode ptr;
        ListNode ptr1 = new ListNode();
        ptr1 = l1;
        ListNode ptr2 = new ListNode();
        ptr2 = l2; int carry = 0;
        while(ptr1!=null && ptr2!=null){
            int sum = ptr1.val + ptr2.val + carry;
            if(sum > 9){
                sum = sum % 10; carry = 1;
            }
            else
                carry = 0;
            if(head == null){
                    head = new ListNode(sum);
            }
            else{
                ptr = head;
                while(ptr.next != null){
                    ptr = ptr.next;
                }
                ptr.next = new ListNode(sum);
            }
            ptr1 = ptr1.next; ptr2 = ptr2.next;
        }
        while(ptr1!=null){
            ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            int sum = ptr1.val + carry;
            if(sum > 9){
                sum = sum % 10; carry = 1;
            }
            else
                carry = 0;
            ptr.next = new ListNode(sum);
            ptr1 = ptr1.next;
        }
        while(ptr2!=null){
            ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            int sum = ptr2.val + carry;
            if(sum > 9){
                sum = sum % 10; carry = 1;
            }
            else
                carry = 0;
            ptr.next = new ListNode(sum);
            ptr2 = ptr2.next;
        }
        if(carry == 1){
            ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = new ListNode(carry);
        }
        return head;
    }
}
