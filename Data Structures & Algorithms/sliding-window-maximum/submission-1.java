class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> maxList = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == k) {
                maxList.add(maxHeap.peek());
                maxHeap.remove(nums[i-k]);
            }
            maxHeap.add(nums[i]);
        }
        if (maxHeap.size() == k) {
            maxList.add(maxHeap.peek());
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}
