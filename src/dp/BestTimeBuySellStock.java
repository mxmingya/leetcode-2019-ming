class Solution {
    // make one buy and one sell
    public int maxProfit(int[] prices) {
        int rMin = Integer.MAX_VALUE, profit = 0;
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        for (int i = 0; i < prices.length; i++)  {
            rMin = prices[i] < rMin ? prices[i] : rMin;
            profit = prices[i] - rMin > profit ? prices[i] - rMin : profit;
        }
        
        return profit;
    }
}