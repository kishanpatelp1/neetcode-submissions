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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        int carry = 0;

        while (ptr1 != null || ptr2 != null || carry != 0) {
            int val = carry;
            if (ptr1 != null) val += ptr1.val;
            if (ptr2 != null) val += ptr2.val;
            carry = val / 10;
            val = val % 10;

            ListNode newNode = new ListNode(val);
            temp.next = newNode;
            temp = temp.next;
            if (ptr1 != null) ptr1 = ptr1.next;
            if (ptr2 != null) ptr2 = ptr2.next;
        } 

        return dummy.next;
    }
}
