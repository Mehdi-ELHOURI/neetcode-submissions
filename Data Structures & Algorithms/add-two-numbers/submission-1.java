class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toNode(toBigInteger(l1).add(toBigInteger(l2)));
    }

    private java.math.BigInteger toBigInteger(ListNode head) {
        var strBuilder = new StringBuilder();
        while (head != null) {
            strBuilder.append(head.val);
            head = head.next;
        }
        return new java.math.BigInteger(strBuilder.reverse().toString());
    }

    private ListNode toNode(java.math.BigInteger n) {
        var str = n.toString();
        var dummy = new ListNode();
        var curr = dummy;
        for (int i = str.length() - 1; i >= 0; i--) {
            curr.next = new ListNode(str.charAt(i) - '0');
            curr = curr.next;
        }
        return dummy.next;
    }
}