class Solution {
    
    public int profit(int idx, int buy, int prices[], int dp[][]){
        
        if(idx == prices.length) return 0;
        
        if(dp[idx][buy] != -1) return dp[idx][buy];
        
        if(buy == 1){
            
            int get = -prices[idx] + profit(idx+1,0,prices,dp);
            int dontGet = 0 + profit(idx+1, 1, prices,dp);
            
            return dp[idx][buy] = Math.max(get,dontGet);
        }else{
            int sell = prices[idx] + profit(idx+1,1,prices,dp);
            int dontSell = 0 + profit(idx+1,0,prices,dp);
            
            return dp[idx][buy] = Math.max(sell, dontSell);
        }
        
    }
    
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int dp[][] = new int[n][2];
        
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        
        return profit(0,1,prices,dp);
    }
}