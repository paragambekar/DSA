class Solution {
    
    private int dist(String s1, String s2, int idx1, int idx2, int dp[][]){
        
        if(idx1 < 0){
            return idx2+1;
        }
        
        if(idx2 < 0){
            return idx1+1;
        }
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 0 + dist(s1,s2,idx1-1,idx2-1,dp);
        }else{
            int insert = 1 + dist(s1,s2,idx1,idx2-1,dp);
            int delete = 1 + dist(s1,s2,idx1-1,idx2,dp);
            int replace = 1 + dist(s1,s2,idx1-1,idx2-1,dp);
            
            return dp[idx1][idx2] =  Math.min(insert,Math.min(delete,replace));
        }
        
    }
    
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return dist(word1,word2,word1.length()-1,word2.length()-1,dp);
        
    }
}