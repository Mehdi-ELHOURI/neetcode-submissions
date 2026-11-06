class LRUCache {
    private final int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insertLast(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insertLast(node);
        if (cache.size() > capacity) {
            cache.remove(head.next.key);
            remove(head.next);
        }
    }

    private void remove(Node node) {
        Node next = node.next, prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void insertLast(Node node) {
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        this.tail.prev = node;
        node.next = this.tail;
    }

    private class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}