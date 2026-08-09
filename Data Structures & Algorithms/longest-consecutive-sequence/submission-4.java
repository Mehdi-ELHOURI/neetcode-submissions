class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int maxSeq = 1;
        var set = new HashSet<Integer>();
        for (var num : nums) {
            set.add(num);
        }
        for(int i = 0; i < nums.length; i++) {
            int k = 1;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + k)) {
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