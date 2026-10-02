class LinkedList {
    private Node head;

    public LinkedList() {}

    public int get(int index) {
        var current = head;
        while (current != null && index > 0) {
            current = current.next;
            index--;
        }
        return current == null ? -1 : current.val;
    }

    public void insertHead(int val) {
        head = new Node(val, head);
    }

    public void insertTail(int val) {
        if (head == null) {
            insertHead(val);
            return;
        }

        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val, null);
    }

    public boolean remove(int index) {
        if (head == null)
            return false;

        if (index == 0) {
            head = head.next;
            return true;
        }

        var prev = head;
        while (index > 1 && prev != null) {
            prev = prev.next;
            index--;
        }
        if (prev == null || prev.next == null)
            return false;

        prev.next = prev.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        var current = head;
        var list = new ArrayList<Integer>();
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }

    private class Node {
        int val;
        Node next;

        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
