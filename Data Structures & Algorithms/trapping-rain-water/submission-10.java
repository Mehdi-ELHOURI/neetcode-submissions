class Solution {
    public int trap(int[] height) {
        int res = 0, n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = height[0];
        rmax[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(height[i], lmax[i-1]);
            rmax[n-i-1] = Math.max(height[n-i-1], rmax[n-i]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return res;
    }
}