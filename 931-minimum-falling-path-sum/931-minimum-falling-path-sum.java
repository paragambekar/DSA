class Solution {
    
    private int minSum(int matrix[][], int i, int j, int dp[][]){
        
        int n = matrix.length;
        
        if(j < 0 || j >=n){
            return Integer.MAX_VALUE;
        }
        
        if(i == n-1){
            return matrix[i][j];
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int down = minSum(matrix,i+1,j,dp);
        
        int leftd = minSum(matrix,i+1,j-1,dp); 
     
        int rightd =   minSum(matrix,i+1,j+1,dp);
        
        return dp[i][j] =  Math.min(down,Math.min(leftd,rightd)) + matrix[i][j];
        
    }
    
    public int minFallingPathSum(int[][] matrix) {
     
        int n = matrix.length;
        int minSum  = Integer.MAX_VALUE;
        
        int dp[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        
        for(int i = 0; i < n; i++){
            minSum = Math.min(minSum, minSum(matrix,0,i,dp));
        }
        
        return minSum;
        
    }
}