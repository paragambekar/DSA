class Solution {
    
   
    
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
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(j == 0){
                    dp[i][j] = grid[i][j]+ dp[i-1][j];
                }else{
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
            }
        }
        
//         for(int i = 1; i < m; i++){
//             for(int j = 0; j < n; j++){
                
//                System.out.print(dp[i][j]+" ");
                
//             }
//             System.out.println();
//         }
        
        
        
        int min = dp[m-1][0];
        for(int i = 0; i < n; i++){
            min = Math.min(min,dp[m-1][i]);
        }
        return min;
        
        
      
    }
}