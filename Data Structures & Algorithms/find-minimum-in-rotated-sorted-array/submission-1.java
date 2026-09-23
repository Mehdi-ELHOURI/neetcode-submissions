class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, n = nums.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isMin(nums, m)) return nums[m];
            if (nums[m] > nums[r]) l = m + 1;
            else r = m - 1; 
        }
        return -1;
    }

    private boolean isMin(int[] nums, int i) {
        int n = nums.length;
        if (n == 1) return true;
        if (i == 0) return nums[n - 1] > nums[0];
        return nums[i] < nums[i - 1];
    }
}
