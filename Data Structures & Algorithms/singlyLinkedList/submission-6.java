class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = tail = new Node(-1, null);
    }

    public int get(int index) {
        Node current = head.next;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.value;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        var newHead = new Node(val, head.next);
        head.next = newHead;
        if (newHead.next == null) {
            tail = newHead;
        }
    }

    public void insertTail(int val) {
        var newTail = new Node(val, null);
        tail.next = newTail;
        tail = newTail;
    }

    public boolean remove(int index) {
        Node current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current != null && current.next != null) {
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        var current = head.next;
        var list = new ArrayList<Integer>();
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        return list;
    }

    private class Node {
        int value;
        Node next;

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
