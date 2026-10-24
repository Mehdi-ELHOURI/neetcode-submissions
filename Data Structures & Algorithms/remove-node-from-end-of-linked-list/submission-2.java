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
        ListNode node1 = new ListNode(-1, head), res = node1, node2 = head;
        while (n > 0) {
            node2 = node2.next;
            n--;
        }
        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node1.next = node1.next.next;
        return res.next;
    }
}
