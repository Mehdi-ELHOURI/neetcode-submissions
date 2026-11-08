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
        int imin = 0;
        for (int i = 1; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < (lists[imin] == null ? Integer.MAX_VALUE : lists[imin].val)) {
                imin = i;
            }
        }
        if (lists[imin] == null) return null; 
        ListNode res = lists[imin];
        lists[imin] = lists[imin].next;
        res.next = mergeKLists(lists);
        return res;
    }
}
