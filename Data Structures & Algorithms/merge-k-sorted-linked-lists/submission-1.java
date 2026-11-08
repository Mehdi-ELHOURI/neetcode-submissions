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
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (var list : lists) {
            var curr = list;
            while (curr != null) {
                minHeap.offer(curr);
                curr = curr.next;
            }
        }
        ListNode dummy = new ListNode(), curr = dummy;
        while (minHeap.size() > 0) {
            curr.next = minHeap.poll();
            curr = curr.next;
        }
        return dummy.next;
    }
}
