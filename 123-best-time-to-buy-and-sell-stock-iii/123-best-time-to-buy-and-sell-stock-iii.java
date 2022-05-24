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
        
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        // for(int i = 0; i <= prices.length; i++){
        //     for(int j = 0; j < 2; j++){
        //         for(int k = 0; k < 3; k++){
        //             dp[i][j][k] = -1;
        //         }
        //     }
        // }
        
        for(int idx = 0; idx <= n; idx++){
            for(int buy = 0; buy <=1; buy++){
                dp[idx][buy][0] = 0;
            }
        }
        
        for(int buy = 0; buy <= 1; buy++){
            for(int cap = 0; cap <=2; cap++){
                dp[0][buy][cap] = 0;
            }
        }
        
        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 2; cap > 0; cap--){
                    
                    
                    if(buy == 1){
                          int canBuy = -prices[idx] + dp[idx+1][0][cap];
                          int skipBuy = 0 + dp[idx+1][1][cap];

                          dp[idx][buy][cap] = Math.max(canBuy,skipBuy);
                    }else{
                         int sell = prices[idx] + dp[idx+1][1][cap-1];
                        int skipSell = 0 + dp[idx+1][0][cap];

                         dp[idx][buy][cap] = Math.max(sell,skipSell);
                    }
                    
                }
            }
        }
        
        return dp[0][1][2];
        // return profit(0,1,2,prices,dp);
    }
}