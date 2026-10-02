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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        var current = head;
        var list = new ArrayList<Integer>();
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        var res = new ListNode(list.get(list.size() - 1));
        current = res;
        for (int i = list.size() - 2; i >= 0; i--) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return res;
    }
}
