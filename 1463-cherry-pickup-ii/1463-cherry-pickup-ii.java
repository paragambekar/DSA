class Solution {

    
    public int cherry(int grid[][], int i, int j1, int j2,int dp[][][]){
        
        int m = grid[0].length;
        int n = grid.length;
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return -999;
        }
        
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        
        int maxi = -999;
        
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <=1; dj2++){
                
                int c1 = j1+dj1;
                int c2 = j2+dj2;
                
               int value = 0;
                if(j1 == j2){
                    value += grid[i][j1];
                }else{
                    value += grid[i][j1] + grid[i][j2];
                }
                
                value += cherry(grid,i+1,c1,c2,dp);
                
                maxi = Math.max(maxi,value);
                
            }
        }
        
        return dp[i][j1][j2] = maxi;
        
        
    }
    
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int dp[][][] = new int[n][m][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < m; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return cherry(grid,0,0,grid[0].length-1,dp);
    }
}