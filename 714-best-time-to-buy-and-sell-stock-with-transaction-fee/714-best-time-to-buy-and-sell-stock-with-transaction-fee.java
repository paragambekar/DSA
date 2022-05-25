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
        int dp[][] = new int [n][2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        
        return profit(0,1,fee,prices,dp);
        
    }
}