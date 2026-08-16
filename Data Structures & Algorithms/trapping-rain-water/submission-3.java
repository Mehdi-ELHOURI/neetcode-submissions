class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        if (height.length < 2) {
            return 0;
        }
        while (height[i + 1] > height[i]) i++;
        while (height[j - 1] > height[j]) j--;
        while (i < j) {
            int k = 1;
            if (height[i] < height[j]) {
                while (height[i] > height[i + k] && (i + k) < j) {
                    res += height[i] - height[i + k];
                    k++;
                }
                i = i + k;
            } else {
                while (height[j] > height[j - k] && (j - k) > i) {
                    res += height[j] - height[j-k];
                    k++;
                }
                j = j - k;                
            }
        }
        return res;
    }
}
