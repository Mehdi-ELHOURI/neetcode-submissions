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
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (var list : lists) {
            if (list != null) {
                minHeap.offer(list);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(), curr = dummy, min;
        while (minHeap.size() > 0) {
            min = minHeap.poll();
            if (min.next != null)
                minHeap.offer(min.next);
            curr.next = min;
            curr = curr.next;
        }
        return dummy.next;
    }
}
