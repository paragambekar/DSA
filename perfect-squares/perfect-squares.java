class Solution {
   
    private int num(int n, int dp[]){
        
        if(n <= 0){
            return 0;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int myans = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            
          int ans = num(n-(i*i),dp);  
            myans = Math.min(myans,ans);
        }
        
        
        return dp[n] =  myans+1;
        
        
    }
   
    
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // int ans =  num(n,dp);
        // return ans;
        
        dp[0] = 0;
        
        for(int i = 1; i <=n; i++){
            
            int myans = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                
                myans = Math.min(myans,dp[i-(j*j)]);
                
            }
            dp[i] = myans + 1;
            
        }
        
        return dp[n];
        
    }
}