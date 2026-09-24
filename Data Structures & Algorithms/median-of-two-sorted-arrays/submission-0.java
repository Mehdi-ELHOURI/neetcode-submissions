class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arrA = nums1, arrB = nums2;

        if (arrA.length > arrB.length) {
            int[] tmp = arrA;
            arrA = arrB;
            arrB = tmp;
        }

        int l = 0, r = arrA.length, total = nums1.length + nums2.length, half = (total + 1) / 2;
        int i, j, leftA, leftB, rightA, rightB;

        while (l <= r) {
            i = l + (r - l) / 2;
            j = half - i;
            leftA = (i > 0) ? arrA[i - 1] : Integer.MIN_VALUE;
            rightA = (i < arrA.length) ? arrA[i] : Integer.MAX_VALUE;
            leftB = (j > 0) ? arrB[j - 1] : Integer.MIN_VALUE;
            rightB = (j < arrB.length) ? arrB[j] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if (total % 2 == 0) {
                    return ((double) Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}