class LRUCache {
    private final int capacity;
    private int size;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.size = 0;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            //Extract node and value from map
            Node node = map.get(key);
            value = node.value;
            
            //Remove node from middle of linkedlist
            Node next = node.next, prev = node.prev;
            next.prev = prev;
            prev.next = next;
            
            //Add node to the tail of linkedlist
            prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            tail.prev = node;
            node.next = tail;
        }
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Extract node
            Node node = map.get(key);
            node.value = value;

            // Remove node from middle of linkedlist
            Node next = node.next, prev = node.prev;
            next.prev = prev;
            prev.next = next;
            
            // Add node to the tail of linkedlist
            prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            tail.prev = node;
            node.next = tail;
        } else {
            Node node = new Node(key, value);
            // Add node to Map
            map.put(key, node);
            // Add node to the tail of linkedlist
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            tail.prev = node;
            node.next = tail;
            if (++size > capacity) {
                //Remove LRU
                Node remove = head.next, next = remove.next;
                map.remove(remove.key);
                head.next = next;
                next.prev = head;
                --size;
            }
        }
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