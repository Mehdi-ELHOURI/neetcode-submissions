class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, l = 0, r = 1, minPrice = prices[0];
        while(r < prices.length) {
            if (prices[r] < minPrice) {
                minPrice = prices[r];
                l = r;
                r = l + 1;
            } else {
                maxProfit = Math.max(maxProfit, prices[r] - minPrice);
                r++;
            }
        }
        return maxProfit;
    }
}
