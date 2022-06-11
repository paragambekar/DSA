class Solution {
    
    public int countWays(String s, String t, int idx1, int idx2, int dp[][]){
        
        if(idx2 < 0) return 1;
        
        if(idx1 < 0) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        // if(idx1 == 0){
        //     if(s.charAt(idx1) == t.charAt(idx2)){
        //        return 1; 
        //     }
        // }
        
    
        if(s.charAt(idx1) == t.charAt(idx2)){
            return dp[idx1][idx2] =  countWays(s,t,idx1-1,idx2-1,dp) + countWays(s,t,idx1-1,idx2,dp);
        }else{
            return dp[idx1][idx2] = countWays(s,t,idx1-1,idx2,dp);
        }
        
        
        
    }
    
    public int numDistinct(String s, String t) {
        
        int dp[][] = new int[s.length()+1][t.length()+1];
//         for(int row[] : dp){
//             Arrays.fill(row,-1);
//         }
        
//         return countWays(s,t,s.length()-1, t.length()-1,dp);
        
        for(int i = 0; i <= s.length(); i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= t.length(); i++) dp[0][i] = 0;
        
        for(int idx1 = 1; idx1 <= s.length(); idx1++){
            for(int idx2 = 1; idx2 <= t.length(); idx2++){
                
                
                if(s.charAt(idx1-1) == t.charAt(idx2-1)){
                     dp[idx1][idx2] =  dp[idx1-1][idx2-1] + dp[idx1-1][idx2]; 
                }else{
                     dp[idx1][idx2] =  dp[idx1-1][idx2];
                }
                
            }
        }
        
        return dp[s.length()][t.length()];
        
        
    }
}