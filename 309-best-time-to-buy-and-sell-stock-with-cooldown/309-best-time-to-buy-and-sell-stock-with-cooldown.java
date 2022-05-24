class Solution {
    
    private int profit(int idx, int buy, int prices[], int dp[][]){
        
        if(idx >= prices.length) return 0;
        
        if(dp[idx][buy] != -1) return dp[idx][buy];
      
        if(buy == 1){
            int canBuy = -prices[idx] + profit(idx+1, 0, prices,dp); 
            int skipBuy = 0 + profit(idx+1, 1, prices,dp);
            
            return dp[idx][buy] =  Math.max(canBuy,skipBuy);
        }else{
            
            int sell = prices[idx] + profit(idx+2,1,prices,dp);
            int skipSell = 0 + profit(idx+1,0,prices,dp);
            
            return dp[idx][buy] = Math.max(sell, skipSell);
            
        }
        
        
    }
    
    public int maxProfit(int[] prices) {
        
        int dp[][] = new int[prices.length][2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        
        return profit(0,1,prices,dp);
        
    }
}