/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val;	}
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge cases: empty list, single node, or k == 1 means nothing to reverse.
        if (head == null || head.next == null || k == 1)
            return head;

        // Collect every node into an array so we can index into it by position.
        var current = head;
        var list = new ArrayList<ListNode>();
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        int size = list.size();

        // If the whole list is shorter than k, no full group exists -> unchanged.
        if (size < k)
            return head;

        // Process each full group of k nodes; group i covers indices [i-k, i-1].
        for (int i = k; i <= size; i += k) {
            // Reverse the group in place by pointing each node to the one before it.
            // j = i-k+1 .. i-1  =>  list[j].next = list[j-1]
            for (int j = i - k + 1; j < i; j++) {
                list.get(j).next = list.get(j - 1);
            }

            // Now the group's last node (list[i-k]) must point to the NEXT group's
            // last node (which will become its head after that group is reversed).
            if (i + k <= size) {
                // A full next group exists: link to its head (index i+k-1).
                list.get(i - k).next = list.get(i + k - 1);
            } else if (i < size) {
                // Leftover tail (fewer than k nodes): link to its first node (index i).
                list.get(i - k).next = list.get(i);
            } else {
                // This is the final group: terminate the list.
                list.get(i - k).next = null;
            }
        }
        // After reversal, the first group's new head is at index k-1.
        return list.get(k - 1);
    }
}