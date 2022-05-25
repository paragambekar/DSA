class Solution {
    
    private int profit(int idx, int buy, int fee, int prices[], int dp[][]){
        
        if(idx == prices.length) return 0;
        
        if(dp[idx][buy] != -1) return dp[idx][buy];  
        
        if(buy == 1){
            return dp[idx][buy] =  Math.max((-prices[idx] + profit(idx+1, 0, fee, prices,dp)),(profit(idx+1,1,fee,prices,dp)));
        }else{
            return dp[idx][buy] = Math.max(((prices[idx]-fee) + profit(idx+1, 1, fee, prices,dp)),(profit(idx+1,0,fee,prices,dp)));
        }
        
    }
    
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        int dp[][] = new int [n+1][2];
        // for(int row[]: dp){
        //     Arrays.fill(row,-1);
        // }
        
        for(int idx = n-1; idx >=0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                
                if(buy == 1){
                    
                    int take = -prices[idx] + dp[idx+1][0];
                    int notTake = 0 + dp[idx+1][1];
                    
                    dp[idx][buy] = Math.max(take,notTake);
                    
                }else{
                    
                    int sell = (prices[idx]-fee) + dp[idx+1][1];
                    int notSell = 0 + dp[idx+1][0];
                    
                    dp[idx][buy] = Math.max(sell,notSell);
                    
                }
            }
        }
        
        return dp[0][1];
        
        
        // return profit(0,1,fee,prices,dp);
        
    }
}