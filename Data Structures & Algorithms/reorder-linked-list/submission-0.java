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
        if (head.next == null) return;
        var nodes = toNodesList(head);
        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i++).next = nodes.get(j);
            if (i == j) break;
            nodes.get(j--).next = nodes.get(i);
        }
        nodes.get(i).next = null;
    }

    private List<ListNode> toNodesList(ListNode head) {
        var curr = head;
        var list = new ArrayList<ListNode>();
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        return list;
    }
}