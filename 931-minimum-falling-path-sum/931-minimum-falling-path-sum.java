class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        
        int dp[][] = new int[n][n];
        
        for(int i = n-1; i >=0; i--){
            for(int j = n-1; j >=0; j--){
                
                // base case
                if(i == n-1){
                    dp[i][j] = matrix[i][j];
                }else{
                    
                    int down = dp[i+1][j];
                    int leftd = Integer.MAX_VALUE;
                    int rightd = Integer.MAX_VALUE;
                    
                    if(j > 0){
                        leftd = dp[i+1][j-1];
                    }
                    
                    if(j+1 < n){
                        rightd = dp[i+1][j+1];
                    }
                    
                    dp[i][j] = matrix[i][j] +  Math.min(down,Math.min(leftd,rightd));
                    
                }
                
            }
        }
        
        int minsum = dp[0][0];
        for(int i = 1; i < n; i++){
            minsum = Math.min(minsum,dp[0][i]);
        }
        
        return minsum;
        
    }
}