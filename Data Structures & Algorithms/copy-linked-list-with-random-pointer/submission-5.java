/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeToCopy = new HashMap<>();
        nodeToCopy.put(null, null);

        Node curr = head;
        while (curr != null) {
            nodeToCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            var copy = nodeToCopy.get(curr);
            copy.next = nodeToCopy.get(curr.next);
            copy.random = nodeToCopy.get(curr.random);
            curr = curr.next;
        }
        return nodeToCopy.get(head);
    }
}
