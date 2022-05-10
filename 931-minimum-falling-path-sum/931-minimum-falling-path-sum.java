class Solution {
    
    public int fallingSum(int i, int j, int grid[][], int dp[][]){
        
        if(i < 0 || j < 0 || j >= grid.length) return Integer.MAX_VALUE;
        
        if(i == 0) return grid[i][j];
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int up = fallingSum(i-1,j,grid,dp);
        int left = fallingSum(i-1,j-1,grid,dp);
        int right = fallingSum(i-1,j+1,grid,dp);
        
        return dp[i][j] = grid[i][j] + Math.min(up, Math.min(left,right));
        
    }
    
    public int minFallingPathSum(int[][] matrix) {
        
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        
        int dp[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                
                if(i > 0) up = dp[i-1][j];
                if(i > 0 && j > 0) left = dp[i-1][j-1];
                if(i > 0 && j < n-1) right = dp[i-1][j+1];
                
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left,right));
                
            }
        }
        
        // int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[n-1][i]);
            
        }
        
        return min;
        
        // for(int row[] : dp){
        //     Arrays.fill(row, -1);
        // }
        
        
        // for(int i = 0; i < n; i++){
        //     int ans = fallingSum(n-1, i, matrix,dp);
        //     min = Math.min(ans,min);
        // }
        
        // return min;
        
    }
}