class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        int maxnum = prices[n-1];
        int profit = 0;
        
        for(int i = n-2; i>=0; i--){
            maxnum = Math.max(maxnum,prices[i]);
            profit = Math.max(profit,maxnum-prices[i]);
            
        }
        
        return profit;
        
        
    }
}