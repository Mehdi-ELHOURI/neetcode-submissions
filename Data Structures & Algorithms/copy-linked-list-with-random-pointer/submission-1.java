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
        if (head == null) return null;
        var orgList = toList(head);
        Map<Integer, Integer> nodeRandPos = new HashMap<>();
        Node dummy = new Node(0), copy = dummy;
        for (int i = 0; i < orgList.size(); i++) {
            nodeRandPos.put(i, orgList.indexOf(orgList.get(i).random));
            copy.next = new Node(orgList.get(i).val);
            copy = copy.next;
        }
        var copyAsList = toList(dummy.next);
        for (int i = 0; i < copyAsList.size(); i++) {
            copyAsList.get(i).random =
                nodeRandPos.get(i) == -1 ? null : copyAsList.get(nodeRandPos.get(i));
        }
        return copyAsList.getFirst();
    }

    private List<Node> toList(Node head) {
        var res = new ArrayList<Node>();
        while (head != null) {
            res.add(head);
            head = head.next;
        }
        return res;
    }
}
