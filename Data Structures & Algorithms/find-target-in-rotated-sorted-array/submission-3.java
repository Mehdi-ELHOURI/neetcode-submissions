class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivot = findMinIndex(nums) - 1;
        return Math.max(
            binarySearch(nums, l, pivot, target),
            binarySearch(nums, pivot + 1, r, target));
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

    private static int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
}
