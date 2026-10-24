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
        return sum(l1, l2, 0);
    }

    private ListNode sum(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) return carry > 0 ? new ListNode(1) : null;
        int sum = 0;
        if (l1 == null) {
            sum = carry + l2.val;
            if (sum >= 10) return new ListNode(sum - 10, sum(null, l2.next, 1));
            else return new ListNode(sum, sum(null, l2.next, 0));
        }
        if (l2 == null) {
            sum = carry + l1.val;
            if (sum >= 10) return new ListNode(sum - 10, sum(l1.next, null, 1));
            else return new ListNode(sum, sum(l1.next, null, 0));
        }
        sum = carry + l1.val + l2.val;
        if (sum >= 10) return new ListNode(sum - 10, sum(l1.next, l2.next, 1));
        else return new ListNode(sum, sum(l1.next, l2.next, 0));
    }
}
