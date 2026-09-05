class MinStack {
    private static final int MAX_SIZE = 30000;
    private final int[] stackArr;
    private final int[] minArr;

    private int current;

    public MinStack() {
        stackArr = new int[MAX_SIZE];
        minArr = new int[MAX_SIZE];
        current = -1;
    }
    
    public void push(int val) {
        current++;
        stackArr[current] = val;
        if (current == 0 || val < minArr[current - 1]) {
            minArr[current] = val;
        } else {
            minArr[current] = minArr[current - 1];
        }
    }
    
    public void pop() {
        current--;
    }
    
    public int top() {
        return stackArr[current];
    }
    
    public int getMin() {
        return minArr[current];
    }
}
