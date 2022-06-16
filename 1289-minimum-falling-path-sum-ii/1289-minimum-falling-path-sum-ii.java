class Solution {
    
    private int pathSum(int grid[][], int i, int prev, int dp[][]){
        
        if(i == grid.length-1){
            int temp = Integer.MAX_VALUE;
            for(int l = 0; l < grid.length; l++){
                if(l != prev){
                    temp = Math.min(temp,grid[grid.length-1][l]);
                }
            }
            return temp;
        }
        
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < grid.length; k++){
            if(k != prev){
                int sum = grid[i][k] +  pathSum(grid,i+1,k,dp);
                ans = Math.min(ans,sum);
            }
        }
        return dp[i][prev+1] = ans;
        
    }
    
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        int dp[][] = new int[n][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return pathSum(grid,0,-1,dp);
        
    }
}