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
        while (prev != null && prev.next != null && i <= size - n) {
            if (i == size - n) {
                prev.next = prev.next.next;
            }
            i++;
            prev = prev.next;
        }
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
