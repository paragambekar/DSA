class Solution {
    
    public int lcs(String s1, String s2, int idx1, int idx2, int dp[][]){
        
        if(idx1 < 0 || idx2 < 0) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return 1 + lcs(s1,s2,idx1-1, idx2-1,dp);
        }
        
        return dp[idx1][idx2] = Math.max((lcs(s1,s2,idx1-1,idx2,dp)),(lcs(s1,s2,idx1,idx2-1,dp)));
        
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int l1 = text1.length();
        int l2 = text2.length();
        int dp[][] = new int[l1][l2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        
        return lcs(text1,text2,l1-1,l2-1,dp);
        
    }
}