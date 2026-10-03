class MyLinkedList {
    private Node head, tail;
    private int size;

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1); // 2 Dummy nodes
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        Node curr;
        if (index < size / 2) {
            curr = head.next;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail.prev;
            for (int i = 0; i < size - index - 1; i++) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        Node prevNode;
        if (index < size / 2) {
            prevNode = head;
            for (int i = 0; i < index; i++) {
                prevNode = prevNode.next;
            }
        } else {
            prevNode = tail;
            for (int i = 0; i <= size - index; i++) {
                prevNode = prevNode.prev;
            }
        }

        Node next = prevNode.next;
        Node newNode = new Node(val);
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = next;
        next.prev = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        Node prevNode;
        if (index < size / 2) {
            prevNode = head;
            for (int i = 0; i < index; i++) {
                prevNode = prevNode.next;
            }
        } else {
            prevNode = tail;
            for (int i = 0; i <= size - index; i++) {
                prevNode = prevNode.prev;
            }
        }

        Node curr = prevNode.next;
        Node next = curr.next;
        prevNode.next = next;
        next.prev = prevNode;

        size--;
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