class Solution {
    
    public int cherry(int i, int j1, int j2, int grid[][], int dp[][][]){
        
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length){
            return -999;
        }
        
        if(i == grid.length - 1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int ans = Integer.MIN_VALUE;
        for(int m = -1; m <=1; m++){
            for(int n = -1; n <= 1; n++){
                
                int cherries = cherry(i+1, j1+m, j2+n, grid,dp);
                ans = Math.max(ans, cherries);
                
            }
        }
        
        if(j1 == j2){
                return dp[i][j1][j2] = grid[i][j1] + ans;
            }else{
                return dp[i][j1][j2] = grid[i][j1] + grid[i][j2] + ans;
            }
        
        
        
        
    }
    
    public int cherryPickup(int[][] grid) {
        
        int m  = grid.length;
        int n = grid[0].length;
        
        int dp[][][] = new int[m][n][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return cherry(0, 0, n-1, grid,dp);
        
    }
}