class Solution {
    
    private int min(int grid[][],int i, int j, int m, int n,int dp[][]){
        
        if(i == m){
            return grid[i][j];
        }
        
        if(i > m || j > n){
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int ans1 = min(grid,i+1,j,m,n,dp);
        int ans2 = min(grid,i+1,j+1,m,n,dp);
        
        return dp[i][j] = grid[i][j] + Math.min(ans1,ans2);
        
    }

    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int m = triangle.size();
        int n = (triangle.get(m-1)).size();
        
        int grid[][] = new int[n][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                
                grid[i][j] = triangle.get(i).get(j);
                
            }
        }
        
        int dp[][] = new int[n][n];
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
       return min(grid,0,0,m-1,n-1,dp); 
    }
}