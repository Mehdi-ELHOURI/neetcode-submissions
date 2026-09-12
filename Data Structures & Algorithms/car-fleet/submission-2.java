class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] eta = new double[n];
        Map<Integer, Integer> positionIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            eta[i] = (double) (target - position[i]) / speed[i];
            positionIndex.putIfAbsent(position[i], i);
        }
        Arrays.sort(position);
        Deque<Integer> monoStack = new LinkedList<>();
        monoStack.push(position[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (eta[positionIndex.get(position[i])] > eta[positionIndex.get(monoStack.peek())]) {
                monoStack.push(position[i]);
            }
        }
        return monoStack.size();
    }
}