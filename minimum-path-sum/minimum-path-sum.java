class Solution {
    
    private int minPath(int grid[][], int i, int j, int m, int n, int dp[][]){
        
        if(i==m && j == n){
            return grid[i][j];
        }
        
        if(i >m || j > n){
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int right = minPath(grid,i,j+1,m,n,dp);
        int down = minPath(grid,i+1,j,m,n,dp);
        
        return dp[i][j] = grid[i][j]+ Math.min(right,down);
        
    }
    
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        
        
        
        int ans = minPath(grid,0,0,m-1,n-1,dp);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return ans;
    }
}