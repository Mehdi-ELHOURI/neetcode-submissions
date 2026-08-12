class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> res = new HashSet();
        for (int i = 1; i < n - 1; i++) {
            int j = 0, k = n - 1;
            while (j < i && k > i) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                while (j < i && nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                while (i < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }
        }
        return res.stream().toList();
    }
}
