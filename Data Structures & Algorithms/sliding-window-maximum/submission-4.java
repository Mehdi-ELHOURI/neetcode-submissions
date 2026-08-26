class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        List<Integer> maxList = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        while (r < n) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r++);
            if (r - l > k) {
                if (deque.getFirst().equals(l++))
                    deque.removeFirst();
            }
            if (r >= k) {
                maxList.add(nums[deque.getFirst()]);
            }
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}