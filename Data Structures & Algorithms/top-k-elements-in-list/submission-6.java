class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var freqMap = new HashMap<Integer, Integer>();
        for (var num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }
        List<List<Integer>> freqGroups = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            freqGroups.add(new ArrayList<>()); 
        }
        for (var entry : freqMap.entrySet()) {
            freqGroups.get(entry.getValue()-1).add(entry.getKey());
        }
        List<Integer> topFreqList = new ArrayList();
        int i = freqGroups.size() - 1;
        while (topFreqList.size() < k) {
            if (!freqGroups.get(i).isEmpty()) {
                topFreqList.addAll(freqGroups.get(i));
            }
            i--;
        }
        return topFreqList.stream().mapToInt(Integer::intValue).toArray();
    }
}
