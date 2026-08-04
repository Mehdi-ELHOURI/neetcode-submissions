class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] postfixProduct = new int[n];
        prefixProduct[0] = nums[0];
        postfixProduct[n - 1] = nums[n - 1];
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
            postfixProduct[n - 1 - i] = nums[n - 1 - i] * postfixProduct[n - i];
        }
        int[] res = new int[n];
        res[0] = postfixProduct[1];
        res[n - 1] = prefixProduct[n - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = prefixProduct[i-1] * postfixProduct[i+1];
        }
        return res;
    }
}
