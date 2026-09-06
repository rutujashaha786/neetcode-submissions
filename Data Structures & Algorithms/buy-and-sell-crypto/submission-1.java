class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int rmax = prices[n-1];
        int maxProfit = 0;

        for(int i = n - 1; i >= 0; i--){
            rmax = Math.max(rmax, prices[i]);
            maxProfit = Math.max(maxProfit, rmax - prices[i]);
        }

        return maxProfit;
    }
}
