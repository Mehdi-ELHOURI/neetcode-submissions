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
        Node curr = head;
        while (curr != null) {
            nodeToCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            var copy = nodeToCopy.get(curr);
            copy.next = nodeToCopy.getOrDefault(curr.next, null);
            copy.random = nodeToCopy.getOrDefault(curr.random, null);
            curr = curr.next;
        }
        return nodeToCopy.getOrDefault(head, null);
    }
}
