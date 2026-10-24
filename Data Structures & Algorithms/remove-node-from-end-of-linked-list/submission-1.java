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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), prev = dummy;
        int size = size(head);
        int i = 0;
        while (i < size - n) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }

    private int size(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}
