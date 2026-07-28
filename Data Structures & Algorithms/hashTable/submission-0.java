class HashTable {

    private int size;
    private int capacity;
    private LinkedList<Pair>[] arr;

    public HashTable(int capacity) {
        this.capacity = capacity;
        arr = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = new LinkedList();
        }
        size = 0;
    }

    public void insert(int key, int value) {
        int bucket = hash(key);
        for (int i = 0; i < arr[bucket].size(); i++) {
            if (arr[bucket].get(i).key() == key) {
            arr[bucket].set(i, new Pair(key, value));
            return;             }
        }
        arr[bucket].add(new Pair(key, value));
        if (arr[bucket].size() == 1) {
            size ++;
        }
        if ((double) size / capacity >= 0.5) {
            resize();
        }         
    }

    public int get(int key) {
        int bucket = hash(key);         
        return arr[bucket].stream()
                .filter(pair -> pair.key() == key)
                .map(pair -> pair.value())
                .findFirst()
                .orElse(-1);
    }

    public boolean remove(int key) {
        int bucket = hash(key);
        for (int i = 0; i < arr[bucket].size(); i++) {
            if (arr[bucket].get(i).key() == key) {
                arr[bucket].remove(i);
                if (arr[bucket].size() == 0) {
                    size--;
                }
                return true;
            }
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
        capacity *= 2;
        LinkedList<Pair>[] tmp = arr.clone();
        arr = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = new LinkedList();
        }
        size = 0;
        for (LinkedList<Pair> list : tmp) {
            for (Pair pair : list) {
                insert(pair.key(), pair.value());
            }
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    private record Pair(int key, int value) {}
}
