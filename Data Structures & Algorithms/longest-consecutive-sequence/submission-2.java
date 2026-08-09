class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        var map = new TreeMap<Integer, Integer>();
        for (var num : nums) {
            map.putIfAbsent(num, num + 1);
        }
        var keyList = map.navigableKeySet().stream().toList();
        int seq = 1, maxSeq = 1;
        for (int i = 1; i < keyList.size(); i++) {
            if (map.get(keyList.get(i)) == map.get(keyList.get(i-1)) + 1) {
                seq++;
                if (seq > maxSeq) {
                    maxSeq = seq;
                }
                continue;
            }
            seq = 1;
        }
        return maxSeq;
    }
}
