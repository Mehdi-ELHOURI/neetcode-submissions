class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int l = 0; l < prices.length - 1; l++) {
            for (int r = l + 1; r < prices.length; r++) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }        
        }
        return maxProfit;
    }
}
