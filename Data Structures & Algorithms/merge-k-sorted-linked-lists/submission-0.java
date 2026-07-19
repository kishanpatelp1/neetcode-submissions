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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (true) {
            ListNode ptr = null;
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (lists[i] == null) continue;
                else if (ptr == null || lists[i].val < ptr.val) {
                    ptr = lists[i];
                    index = i;
                }
            }
            
            if (ptr == null) break;
            temp.next = ptr;
            lists[index] = lists[index].next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
