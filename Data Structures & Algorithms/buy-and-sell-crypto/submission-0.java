class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] rmax = new int[n];
        rmax[n - 1] = prices[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rmax[i] = Math.max(prices[i], rmax[i + 1]);
        }

        int maxProfit = 0;
        for(int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit, rmax[i] - prices[i]);
        }

        return maxProfit;
    }
}
