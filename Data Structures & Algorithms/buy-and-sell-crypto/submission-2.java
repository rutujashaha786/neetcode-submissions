class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int lmin = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < n; i++){
            lmin = Math.min(lmin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lmin);
        }

        return maxProfit;
    }
}
