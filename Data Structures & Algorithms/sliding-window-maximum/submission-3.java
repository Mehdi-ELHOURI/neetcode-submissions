class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> maxList = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            maxHeap.add(nums[i]);
            if (maxHeap.size() == k) {
                maxList.add(maxHeap.peek());
                maxHeap.remove(nums[i - k + 1]);
            }
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}
