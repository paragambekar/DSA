class Solution {
    
    public int solve(int coins[], int idx, int amt, int dp[][]){
        
        // if(target == 0) return 1;
        
        if(idx == 0){
            if((amt % coins[idx]) == 0 || amt == 0){
                return 1;
            }else{
                return 0;
            }
        }
        
        if(dp[idx][amt] != -1) return dp[idx][amt];
        
        int notTake = solve(coins,idx-1,amt,dp);
        
        int take = 0;
        if(coins[idx] <= amt){
            take = solve(coins,idx,amt-coins[idx],dp);
        }
        
        return dp[idx][amt] = notTake + take;
        
    }
    
    public int change(int amount, int[] coins) {
        
        int n  = coins.length;
        int dp[][] = new int[n][amount+1];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return solve(coins,coins.length-1,amount,dp);
        
    }
}