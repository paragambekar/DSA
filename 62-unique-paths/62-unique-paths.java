class Solution {
    
    public int pathsHelper(int m, int n, int dp[][]){
        
         if(m == 0 && n == 0) return 1;
        
         if(m < 0 || n < 0) return 0;
        
        if(dp[m][n] != -1) return dp[m][n];
        
        return dp[m][n] = (pathsHelper(m-1,n,dp) + pathsHelper(m,n-1,dp));
        
        
    }
    
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return pathsHelper(m-1,n-1,dp);        
    }
}