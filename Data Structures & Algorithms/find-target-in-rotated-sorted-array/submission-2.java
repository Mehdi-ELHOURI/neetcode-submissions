class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivot = findMinIndex(nums) - 1;
        return Math.max(bs(nums, l, pivot, target), bs(nums, pivot + 1, r, target));
    }

    private static int findMinIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r])
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    private static int bs(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (nums[m] == target) {
            return m;
        }
        return nums[m] > target ? bs(nums, l, m - 1, target) : bs(nums, m + 1, r, target);
    }
}
