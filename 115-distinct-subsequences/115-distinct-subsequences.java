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
        
        int dp[][] = new int[s.length()][t.length()];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return countWays(s,t,s.length()-1, t.length()-1,dp);
        
    }
}