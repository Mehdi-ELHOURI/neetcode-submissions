class Solution {
    public int trap(int[] height) {
        int res = 0, lmax = 0, rmax = 0, n = height.length;
        int[] lmaxs = new int[n];
        int[] rmaxs = new int[n];
        for (int i = 0; i < n; i++) {
            lmaxs[i] = lmax = Math.max(height[i], lmax);
            rmaxs[n-i-1] = rmax = Math.max(height[n-i-1], rmax);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(lmaxs[i], rmaxs[i]) - height[i];
        }
        return res;
    }
}
