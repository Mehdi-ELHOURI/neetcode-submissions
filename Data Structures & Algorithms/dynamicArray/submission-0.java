class DynamicArray {

    private int[] arr;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        arr[size++] = n;
    }

    public int popback() {
        return arr[--size];
    }

    private void resize() {
        capacity *= 2;
        int[] tmp = new int[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}