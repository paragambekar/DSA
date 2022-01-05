class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dp[][] = new int[m][n];
        
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                
                    
                    int leftdiag = Integer.MAX_VALUE;
                    if(j - 1 >= 0){
                        leftdiag = Math.min(leftdiag,dp[i-1][j-1]);
                    }
                    
                    int rightdiag = Integer.MAX_VALUE;
                    if(j + 1 < n){
                        rightdiag =Math.min(rightdiag,dp[i-1][j+1]) ;
                    }
                    
                    int top = dp[i-1][j];
                    
                    dp[i][j] = matrix[i][j] + Math.min(leftdiag,Math.min(rightdiag,top));
                    
                }
                
            }
        
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        int minsum = dp[n-1][0];
        
        for(int i = 0; i < n; i++){
            minsum = Math.min(minsum,dp[n-1][i]);
        }
        
        return minsum;
        
        }
        
        
        
        
        
    }
