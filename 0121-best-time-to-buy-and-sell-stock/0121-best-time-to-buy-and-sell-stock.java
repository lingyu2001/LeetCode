class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0, r = 1; 
        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            if (profit > 0) {
                max = Math.max(profit, max);
            } else 
                l = r;
            r++;
        }
        return max;
    }
}