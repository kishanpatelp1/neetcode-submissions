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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (second != null) {
            ListNode front = second.next;
            second.next = prev;
            prev = second;
            second = front;
        }

        ListNode curr = head;

        while (prev != null) {
            ListNode temp1 = curr.next;
            ListNode temp2 = prev.next;
            curr.next = prev;
            prev.next = temp1;
            curr = temp1;
            prev = temp2;
        }
    }
}
