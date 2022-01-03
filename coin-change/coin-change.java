class Solution {
    
    private int coin(int coins[], int index, int amt,int dp[][]){
        
     
        if(amt > 0 && index < 0){
            return Integer.MAX_VALUE-1;
        }
        
        if(index < 0 || amt == 0){
            return 0;
        }
        
        if(dp[index][amt] != 0){
            return dp[index][amt];
        }
        
        if(coins[index] <= amt){
            
            int ans1 = 1 + coin(coins,index,amt-coins[index],dp);
            int ans2 = coin(coins,index-1,amt,dp);
            
            return dp[index][amt] = Math.min(ans1,ans2);
            
        }else{
            
            return dp[index][amt] =  coin(coins,index-1,amt,dp);
        }
        
    }
    
    public int coinChange(int[] coins, int amount) {
       
        int n = coins.length;
        
        int dp[][] = new int[n+1][amount+1];
        
      int ans = coin(coins,coins.length-1,amount,dp);
        
        if(ans != Integer.MAX_VALUE-1){
            return ans;
        }else{
            return -1;
        }
        
    }
}