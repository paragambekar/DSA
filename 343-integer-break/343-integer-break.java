class Solution {
    
    private int intBreak(int n, int dp[]){
        
        if(n == 2){
            return 1;
        }
        
        if(dp[n]!= 0){
            return dp[n];
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 1; i < n; i++){
            
            int smallans = intBreak(n-i,dp);
            
            ans = Math.max(ans,i * Math.max(n-i,smallans)) ;
            
        }
        
        return dp[n] = ans;
        
    }
    
    public int integerBreak(int n) {
        
      int dp[] = new int[n+1];
        
        return intBreak(n,dp);
        
    }
}