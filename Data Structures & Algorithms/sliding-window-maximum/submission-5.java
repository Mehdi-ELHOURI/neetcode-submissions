class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIdx = 0;

        // Store indices in the deque
        Deque<Integer> deque = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            // 1. Maintain monotonic property (descending order)
            // Remove smaller elements from the back because they'll never be the max
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }
            deque.offerLast(r);

            // 2. Remove the index from the front if it's out of the window's range
            if (deque.peekFirst() < r - k + 1) {
                deque.pollFirst();
            }

            // 3. Once the window is full (size k), record the max
            if (r >= k - 1) {
                result[resultIdx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}