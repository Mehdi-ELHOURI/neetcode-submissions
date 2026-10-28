class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1, slow = 0, fast = 0;
        // Cycle detection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Cycle finding
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        };
        return slow;
    }
}
