class Solution {
    public int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;
        int[] min = new int[prices.length] ;
        int[] max = new int[prices.length];
        min[0] = prices[0];
        max[prices.length - 1] = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
            max[prices.length -1 - i] = Math.max(max[prices.length - i], prices[prices.length - 1 - i]);
        }
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, max[i] - min[i]);
        }
        return res >=0? res: 0;
    }
}