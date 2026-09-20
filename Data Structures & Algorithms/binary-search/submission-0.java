class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }

    private static int bs(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int m = (l + r) / 2;
        if (nums[m] == target) {
            return m;
        }
        return nums[m] > target ? bs(nums, l, m - 1, target) : bs(nums, m + 1, r, target);
    }
}
