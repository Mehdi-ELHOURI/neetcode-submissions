class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0, n = piles.length;
        for (var pile : piles) {
            max = Math.max(max, pile);
        }
        int result = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (kokoEatsAllBananas(piles, mid, h)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }

    private boolean kokoEatsAllBananas(int[] piles, int k, int h) {
        double time = 0;
        for (var pile : piles) {
            time += Math.ceil((double) pile / k);
        }
        return time <= h;
    }
}
