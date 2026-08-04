class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = 1;
        post[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            post[n - 1 - i] = nums[n - i] * post[n - i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}
