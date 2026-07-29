class HashTable {
    private int size;
    private int capacity;
    private Node[] arr;

    public HashTable(int capacity) {
        this.capacity = capacity;
        arr = new Node[capacity];
    }

    public void insert(int key, int value) {
        int bucket = hash(key);
        if (arr[bucket] == null) {
            arr[bucket] = new Node(key, value);
        } else {
            Node current = arr[bucket];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            arr[bucket] = new Node(key, value, arr[bucket]);
        }
        size++;
        if (needsResize()) {
            resize();
        }
    }

    public int get(int key) {
        int bucket = hash(key);
        Node current = arr[bucket];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int bucket = hash(key);
        Node prev = null;
        Node current = arr[bucket];
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    arr[bucket] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        Node[] newArr = new Node[capacity *= 2];
        for (Node current : arr) {
            while (current != null) {
                int newBucket = hash(current.key);
                if (newArr[newBucket] == null) {
                    newArr[newBucket] = new Node(current.key, current.value);
                } else {
                    newArr[newBucket] = new Node(current.key, current.value, newArr[newBucket]);
                }
                current = current.next;
            }
        }
        arr = newArr;
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    private boolean needsResize() {
        return (double) size / capacity >= 0.5;
    }

    private static class Node {
        private int key;
        private int value;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node(int key, int value, Node next) {
            this(key, value);
            this.next = next;
        }
    }
}
