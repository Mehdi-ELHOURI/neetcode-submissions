/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode()
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = getMiddle(head);
        ListNode rev = reverseList(mid.next);
        mid.next = null;
        head.next = merge(rev, head.next);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(), curr = res;
        while (list1 != null && list2 != null) {
            // elem 1
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
            
            //elem2
            curr.next = list2;                                    
            list2 = list2.next;
            curr = curr.next;                        
        }
        curr.next = list1 != null ? list1 : list2;
        return res.next;
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head, previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}