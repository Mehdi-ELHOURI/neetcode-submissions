class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                result[stack.peekFirst()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;     
    }
}
