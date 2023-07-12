class Solution {
    public int maxProfit(int[] prices) {
        // calculate the diff array: 
        int[] diff = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        // iterate the diff array
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        if (max < 0) return 0;
        return max;
    }
}