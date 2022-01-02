class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int m = dungeon.length-1;
        int n = dungeon[0].length-1;
        
        int dp[][] = new int[m+1][n+1];
        
        dp[m][n] = Math.max(1, 1 - dungeon[m][n]);
        
//         last row
        for(int i = n-1; i >=0; i--){
            dp[m][i] = Math.max(1, dp[m][i+1]-dungeon[m][i]);
        }
        
        for(int i = m-1; i>=0; i--){
            dp[i][n] = Math.max(1, dp[i+1][n]-dungeon[i][n]);
        }
        
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                
                dp[i][j] =Math.max(1, Math.min(dp[i][j+1],dp[i+1][j]) - dungeon[i][j]); 
                
            }
        }
        
        
//         for(int i = 0; i <= m; i++){
//             for(int j = 0; j <= n; j++){
//                 System.out.print(dp[i][j]+" ");
//             }
//             System.out.println();
//         }
        
        return dp[0][0];
    }
}