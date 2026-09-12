class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] positionSpeedPair = new int[n][2];
        for (int i = 0; i < n; i++) {
            positionSpeedPair[i][0] = position[i];
            positionSpeedPair[i][1] = speed[i];
        }
        Arrays.sort(positionSpeedPair, (a, b) -> Integer.compare(b[0], a[0]));
        Deque<Double> etaStack = new LinkedList<>();
        for (var pair : positionSpeedPair) {
            var eta = eta(target, pair[0], pair[1]);
            if (etaStack.isEmpty() || eta > etaStack.peek()) {
                etaStack.push(eta);
            }
        }
        return etaStack.size();
    }

    private static double eta(int target, int position, int speed) {
        return (double)(target - position) / speed;
    }
}
