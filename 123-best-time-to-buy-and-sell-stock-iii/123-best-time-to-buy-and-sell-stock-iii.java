class Solution {
    
    private int profit(int idx,int buy, int cap, int prices[],int dp[][][]){
        
        if(cap == 0) return 0;
        if(idx == prices.length) return 0;
        
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        
        if(buy == 1){
            int canBuy = -prices[idx] + profit(idx+1, 0,cap,prices,dp);
            int skipBuy = 0 + profit(idx+1, 1,cap,prices,dp);
            
            return dp[idx][buy][cap] = Math.max(canBuy,skipBuy);
        }else{
            
            int sell = prices[idx] + profit(idx+1, 1, cap-1,prices,dp);
            int skipSell = 0 + profit(idx+1, 0,cap,prices,dp);
            
            return dp[idx][buy][cap] = Math.max(sell,skipSell);
            
        }
        
    }
    
    public int maxProfit(int[] prices) {
        
        int dp[][][] = new int[prices.length+1][2][3];
        for(int i = 0; i <= prices.length; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return profit(0,1,2,prices,dp);
    }
}