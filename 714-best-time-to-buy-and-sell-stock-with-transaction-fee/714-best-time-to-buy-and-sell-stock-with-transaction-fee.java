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
        // int dp[][] = new int [n+1][2];
        // for(int row[]: dp){
        //     Arrays.fill(row,-1);
        // }
        
        int after[] = new int[2];
        int curr[] = new int[2];
        
        for(int idx = n-1; idx >=0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                
                if(buy == 1){
                    
                    int take = -prices[idx] + after[0];
                    int notTake = 0 + after[1];
                    
                    curr[buy] = Math.max(take,notTake);
                    
                }else{
                    
                    int sell = (prices[idx]-fee) + after[1];
                    int notSell = 0 + after[0];
                    
                    curr[buy] = Math.max(sell,notSell);
                    
                }
            }
            after = curr;
        }
        
        return after[1];
        
        
        // return profit(0,1,fee,prices,dp);
        
    }
}