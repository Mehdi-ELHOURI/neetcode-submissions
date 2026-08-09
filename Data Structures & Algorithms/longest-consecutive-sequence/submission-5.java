class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSeq = 1;
        var set = new HashSet<Integer>();
        for (var num : nums) {
            set.add(num);
        }
        for (var num : set) {
            if (!set.contains(num - 1)) {
                int k = 1;
                while (set.contains(num + k)) {
                    k++;
                    if (k > maxSeq) {
                        maxSeq = k;
                    }
                }
            }
        }
        return maxSeq;
    }
}