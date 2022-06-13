class Solution {
    
    private int cost(int cuts[], int i, int j, int dp[][]){
        
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        for(int idx = i; idx <=j; idx++){
            int cost = (cuts[j+1]-cuts[i-1]) + cost(cuts,i,idx-1,dp) + cost(cuts,idx+1,j,dp);
            ans = Math.min(ans,cost);
        }
        
        return dp[i][j] = ans;
        
    }
    
    public int minCost(int n, int[] cuts) {
        
        int cut[] = new int[cuts.length+2];
        for(int i = 0; i < cut.length; i++){
            if(i == 0){
                cut[i] = 0;
            }else if(i == cut.length-1){
                cut[i] = n;
            }else{
                cut[i] = cuts[i-1];
            }
        }
        
        // for(int i = 0; i < cut.length; i++){
        //     System.out.print(cut[i]+" ");
        // }
        Arrays.sort(cut);
        int m = cuts.length;
        int dp[][] = new int[m+2][m+2];
//         for(int row[]: dp){
//             Arrays.fill(row,-1);
//         }
        
//         return cost(cut,1,cut.length-2,dp);
        
        for(int i = m; i >=1; i--){
            for(int j = 1; j <= m; j++){
                if(i > j) continue;
                int ans = Integer.MAX_VALUE;
                for(int idx = i; idx <=j; idx++){
                    int cost = (cut[j+1]-cut[i-1]) + dp[i][idx-1] + dp[idx+1][j];
                    ans = Math.min(ans,cost);
                }

                 dp[i][j] = ans;
                
            }
        }
        
        return dp[1][m];
    }
}