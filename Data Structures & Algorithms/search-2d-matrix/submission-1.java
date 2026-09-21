class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, h = m * n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int i = mid / n, j = mid % n;
            if (target == matrix[i][j]) return true;
            if (target > matrix[i][j]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return false;
    }
}
