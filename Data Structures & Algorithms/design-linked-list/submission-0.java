class MyLinkedList {

    Node head, tail;

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1); // 2 Dummy nodes
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        Node curr = head.next;
        int i = 0;
        while(curr.next != null) {
            if (i == index) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val, head, head.next);
        head.next.prev = newHead;
        head.next = newHead;
    }

    public void addAtTail(int val) {
        Node newHead = new Node(val, tail.prev, tail);
        tail.prev.next = newHead;
        tail.prev = newHead;
    }

    public void addAtIndex(int index, int val) {
        Node curr = head, newNode = new Node(val);
        int i = 0;
        while (curr.next != null) {
            if (i == index) {
                newNode.prev = curr;
                newNode.next = curr.next;
                curr.next.prev = newNode;
                curr.next = newNode;
                break;
            }
            i++;
            curr = curr.next;
        }
    }

    public void deleteAtIndex(int index) {
        Node curr = head.next;
        int i = 0;
        while (curr.next != null) {
            if (i == index) {
                curr.next.prev = curr.prev;
                curr.prev.next = curr.next;
                break;
            }
            i++;
            curr = curr.next;
        }
    }

    private class Node {
        int val;
        Node prev;
        Node next;

        private Node(int val) {
            this.val = val;
        }

        private Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */