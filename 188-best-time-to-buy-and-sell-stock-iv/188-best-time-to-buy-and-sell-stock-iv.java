class Solution {
    public int maxProfit(int k, int[] prices) {
        
            int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
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
            for(int cap = 0; cap <= k; cap++){
                dp[n][buy][cap] = 0;
            }
        }
        
        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    
                    
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
        
        return dp[0][1][k];
        
    }
}